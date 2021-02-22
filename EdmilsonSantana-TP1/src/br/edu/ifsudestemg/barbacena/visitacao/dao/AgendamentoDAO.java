package br.edu.ifsudestemg.barbacena.visitacao.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.edu.ifsudestemg.barbacena.visitacao.jdbc.ConnectionFactory;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Agendamento;

public class AgendamentoDAO {
	
	private Connection connection;
	
	public AgendamentoDAO(){
		connection = ConnectionFactory.getConnection();
	}
	
	
	public void adiciona(Agendamento agendamento) {
		String sql = "insert into agendamento (codConfirmacao,codMuseu,cpf,"
				+ "email,dataVisita,hora) values (?,?,?,?,?,?)";
		
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, agendamento.getCodConfirmacao());
			stmt.setLong(2, agendamento.getCodMuseu());
			stmt.setString(3, agendamento.getCpf());
			stmt.setString(4, agendamento.getEmail());
			Date data = new Date(agendamento.getDataVisitacao().getTimeInMillis());
			stmt.setDate(5, data);
			stmt.setLong(6, agendamento.getHora());
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
			//a.setDataHora(c);
			
		}
		return a;
	}
	
//	
//	public List<Agendamento> lista(){
//		String sql = "select * from agendamento ";
//		List<Agendamento> agendamentos = new ArrayList<>();
//		Agendamento agendamento = new Agendamento();
//		Calendar datac = Calendar.getInstance();
//		Date datad = new Date();
//		
//		try {
//			PreparedStatement stmt = connection.prepareStatement(sql);
//			ResultSet rs = stmt.executeQuery();
//			while(rs.next()) {
//				agendamento.setCodConfirmacao(rs.getString("codConfirmacao"));
//				agendamento.setCodMuseu(rs.getLong("codMuseu"));
//				agendamento.setCpf(rs.getString("cpf"));
//				agendamento.setEmail(rs.getString("email"));
//				datad.setTime(rs.getTimestamp("dataHora").getTime());
//				datac.setTime(datad);
//				agendamento.setDataHora(datac);
//				agendamentos.add(agendamento);
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return agendamentos;
//		
//		
//	}
	
	public Long agendamento(String datatxt, Long hora,Long codmuseu){
		String sql = "select count(*) from agendamento where dataVisita=? and hora=? and codmuseu=?";
		
		
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			//Date data = new SimpleDateFormat("dd/MM/yyyy").parse(datatxt);
			Date data = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(datatxt).getTime());
			stmt.setDate(1,data);
			stmt.setLong(2, hora);
			stmt.setLong(3, codmuseu);
			
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
