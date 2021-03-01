package br.edu.ifsudestemg.barbacena.visitacao.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.edu.ifsudestemg.barbacena.visitacao.jdbc.ConnectionFactory;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Agendamento;

public class AgendamentoDAO {
	
	private Connection connection;
	
	public AgendamentoDAO(){
		connection = ConnectionFactory.getConnection();
	}
	
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void adiciona(Agendamento agendamento) {
		String sql = "insert into agendamento (codConfirmacao,codMuseu,"
				+ "email,dataVisita,hora) values (?,?,?,?,?)";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, agendamento.getCodConfirmacao());
			stmt.setLong(2, agendamento.getCodMuseu());
			stmt.setString(3, agendamento.getEmail());
			Date data = new Date(agendamento.getDataVisitacao().getTimeInMillis());
			stmt.setDate(4, data);
			stmt.setLong(5, agendamento.getHora());
			stmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	
	public void remover(Agendamento agendamento) {
		String sql = "delete from agendamento where codConfirmacao=?";
		
		
		try(PreparedStatement stmt = connection.prepareStatement(sql) ){
			stmt.setString(1, agendamento.getCodConfirmacao());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Agendamento recupera(String codConfirmacao){
		
		String sql = "select * from agendamento where codConfirmacao=?";
		
		Calendar c = Calendar.getInstance();
		Agendamento a = null;
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			
			stmt.setString(1, codConfirmacao);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				a = new Agendamento();
				a.setId(rs.getLong("id"));
				a.setCodConfirmacao(rs.getString("codConfirmacao"));
				a.setCodMuseu(rs.getLong("codMuseu"));
				a.setEmail(rs.getString("email"));
				Date d = new Date(rs.getDate("dataVisita").getTime());
				c.setTime(d);
				a.setDataVisitacao(c);
				a.setHora(rs.getLong("hora"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}
	
	public Agendamento recupera(String codConfirmacao, String email){
		
		String sql = "select * from agendamento where codConfirmacao=? and email=?";
		
		Calendar c = Calendar.getInstance();
		Agendamento a = null;
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			
			stmt.setString(1, codConfirmacao);
			stmt.setString(2, email);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				a = new Agendamento();
				a.setId(rs.getLong("id"));
				a.setCodConfirmacao(rs.getString("codConfirmacao"));
				a.setCodMuseu(rs.getLong("codMuseu"));
				a.setEmail(rs.getString("email"));
				Date d = new Date(rs.getDate("dataVisita").getTime());
				c.setTime(d);
				a.setDataVisitacao(c);
				a.setHora(rs.getLong("hora"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}
	
	
	public Long numPessoas(String datatxt, Long hora,Long codmuseu){
		String sql = "select count(*) from agendamento inner join visitante on agendamento.id=visitante.idAgendamento "
				+"where dataVisita=? and hora=? and codmuseu=?";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			
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
	
	
public List<Agendamento> recuperaPorData(String dataTxt, Long codMuseu){
		
		String sql = "select id from agendamento where dataVisita=? and codMuseu=?";
		
		List<Agendamento> agendamentos = new ArrayList<>();
		
		Calendar c1 = Calendar.getInstance();
		
		Agendamento a = null;
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			
			c1.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(dataTxt));
			
			Date data = new Date(c1.getTimeInMillis());
			
			stmt.setDate(1, data);
			stmt.setLong(2, codMuseu);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				a = new Agendamento();
				a.setId(rs.getLong("id"));
				
				agendamentos.add(a);
			}
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return agendamentos;
	}


public List<Agendamento> recuperaPorData(String dataTxt, Long hora, Long codMuseu){
	
	String sql = "select id from agendamento where dataVisita=? and codMuseu=? and hora=?";
	
	List<Agendamento> agendamentos = new ArrayList<>();
	
	Calendar c1 = Calendar.getInstance();
	
	Agendamento a = null;
	
	try (PreparedStatement stmt = connection.prepareStatement(sql);){
		
		c1.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(dataTxt));
		
		Date data = new Date(c1.getTimeInMillis());
		
		stmt.setDate(1, data);
		stmt.setLong(2, codMuseu);
		stmt.setLong(3, hora);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			a = new Agendamento();
			a.setId(rs.getLong("id"));
			
			agendamentos.add(a);
		}
		
	} catch (SQLException | ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return agendamentos;
}
	
	
}
