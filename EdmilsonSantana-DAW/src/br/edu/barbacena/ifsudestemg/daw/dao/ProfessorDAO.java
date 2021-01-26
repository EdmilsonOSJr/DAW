package br.edu.barbacena.ifsudestemg.daw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.barbacena.ifsudestemg.daw.jdbc.ConnectionFactory;
import br.edu.barbacena.ifsudestemg.daw.modelo.Professor;

public class ProfessorDAO {
	Connection connection;

	public ProfessorDAO() {
		this.connection = ConnectionFactory.getConection();
	}
	
	public void adiciona(Professor professor) {
		String sql = "insert into professores (nome,email,grauformacao) values (?,?,?)";
		
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, professor.getNome());
			stmt.setString(2, professor.getEmail());
			stmt.setString(3, professor.getGrauFormacao());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void remove(Professor professor) {
		String sql = "delete from professores where id = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, professor.getId());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void altera(Professor professor) {
		String sql = "update professores set nome=?, email=?, grauformacao=? where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, professor.getNome());
			stmt.setString(2, professor.getEmail());
			stmt.setString(3, professor.getGrauFormacao());
			stmt.setLong(4, professor.getId());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Professor> listaProfessores(){
		List<Professor> professores = new ArrayList<>();
		
		String sql = "select * from professores";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Professor professor = new Professor();
				professor.setId(rs.getLong("id"));
				professor.setNome(rs.getString("nome"));
				professor.setEmail(rs.getString("email"));
				professor.setGrauFormacao(rs.getString("grauformacao"));
				professores.add(professor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return professores;
		
	}
	
}
