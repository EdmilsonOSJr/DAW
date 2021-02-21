package br.edu.ifsudestemg.barbacena.visitacao.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
	
}
