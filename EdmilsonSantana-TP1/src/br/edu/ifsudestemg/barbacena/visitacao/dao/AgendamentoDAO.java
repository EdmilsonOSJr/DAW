package br.edu.ifsudestemg.barbacena.visitacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.edu.ifsudestemg.barbacena.visitacao.jdbc.ConnectionFactory;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Agendamento;

public class AgendamentoDAO {
	
	private Connection connection;
	
	public AgendamentoDAO(){
		connection = ConnectionFactory.getConnection();
	}
	
	
	public void adiciona(Agendamento agendamento) {
		String sql = "insert into agendamento (codConfirmacao,codMuseu,cpf,"
				+ "email,dataHora) values (?,?,?,?,?)";
		
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, agendamento.getCodConfirmacao());
			stmt.setLong(2, agendamento.getCodMuseu());
			stmt.setString(3, agendamento.getCpf());
			stmt.setString(4, agendamento.getEmail());
			Timestamp data = new Timestamp(agendamento.getDataHora().getTimeInMillis());
			stmt.setTimestamp(5, data);
			stmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		
	public Agendamento recupera(String cpf) throws SQLException {
		String sql = "select * from agendamento where cpf=?";
		Calendar c = Calendar.getInstance();
		Agendamento a = new Agendamento();
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, cpf);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			a.setCodConfirmacao(rs.getString("codConfirmacao"));
			a.setCodMuseu(rs.getLong("codMuseu"));
			a.setCpf(rs.getString("cpf"));
			a.setEmail(rs.getString("email"));
			Date d = new Date(rs.getTimestamp("dataHora").getTime());
			c.setTime(d);
			a.setDataHora(c);
			
		}
		return a;
	}
	
	
	public List<Agendamento> lista(){
		String sql = "select * from agendamento ";
		List<Agendamento> agendamentos = new ArrayList<>();
		Agendamento agendamento = new Agendamento();
		Calendar datac = Calendar.getInstance();
		Date datad = new Date();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				agendamento.setCodConfirmacao(rs.getString("codConfirmacao"));
				agendamento.setCodMuseu(rs.getLong("codMuseu"));
				agendamento.setCpf(rs.getString("cpf"));
				agendamento.setEmail(rs.getString("email"));
				datad.setTime(rs.getTimestamp("dataHora").getTime());
				datac.setTime(datad);
				agendamento.setDataHora(datac);
				agendamentos.add(agendamento);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return agendamentos;
		
		
	}
	
	public Long agendamento(String datatxt, String horatxt,Long codmuseu){
		String sql = "select count(*) from agendamento where datahora=? and codmuseu=?";
		Calendar datac = Calendar.getInstance();
		
		
		try {
			Date datad = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(datatxt+" "+horatxt);
			PreparedStatement stmt = connection.prepareStatement(sql);
			datac.setTime(datad);
			Timestamp data = new Timestamp(datac.getTimeInMillis());
			stmt.setTimestamp(1,data);
			stmt.setLong(2, codmuseu);
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			return rs.getLong("count");
			
		} catch (SQLException|ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
