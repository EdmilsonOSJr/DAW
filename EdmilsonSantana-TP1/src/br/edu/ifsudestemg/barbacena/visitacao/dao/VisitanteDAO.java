package br.edu.ifsudestemg.barbacena.visitacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ifsudestemg.barbacena.visitacao.jdbc.ConnectionFactory;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Visitante;

public class VisitanteDAO {

private Connection connection;
	
	public VisitanteDAO(){
		connection = ConnectionFactory.getConnection();
	}
	
	
	public void adiciona(Visitante visitante) {
		String sql = "insert into visitantes (cpf,nome,tipoIngresso,idAgendamento) values (?,?,?,?)";
		
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, visitante.getCpf());
			stmt.setString(2, visitante.getNome());
			stmt.setString(3, visitante.getTipoIngresso());
			stmt.setLong(4, visitante.getIdAgendamento());
			stmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
