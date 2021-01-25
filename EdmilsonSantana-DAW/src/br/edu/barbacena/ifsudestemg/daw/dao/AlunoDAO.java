package br.edu.barbacena.ifsudestemg.daw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;

import br.edu.barbacena.ifsudestemg.daw.jdbc.ConnectionFactory;
import br.edu.barbacena.ifsudestemg.daw.modelo.Aluno;

public class AlunoDAO {
	
	private Connection connection;

	public AlunoDAO(Connection connection) {
		this.connection = ConnectionFactory.getConection();
	}
	
	
	public void adiciona(Aluno aluno) {
		String sql = "insert into aluno (nome,email,datanascimento) values (?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getEmail());
			Date data = new Date(aluno.getDataNascimento().getTimeInMillis());
			stmt.setDate(3, data);
			stmt.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void remove(Aluno aluno) {
		String sql = "delete from aluno where id = ?";
				
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1,aluno.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void altera(Aluno aluno) {
		String sql = "update aluno set nome=?, email=?, datanascimento=? where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getEmail());
			stmt.setDate(3, new Date(aluno.getDataNascimento().getTimeInMillis()));
			stmt.setLong(4, aluno.getId());
			stmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Aluno> listaAlunos(){
		List<Aluno> alunos = new ArrayList<>();
		String sql = "select * from aluno";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(rs.getLong("id"));				
				aluno.setNome(rs.getString("nome"));				
				aluno.setEmail(rs.getString("email"));				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("datanascimento"));
				aluno.setDataNascimento(data);
				alunos.add(aluno);				
			}
		}catch(SQLException e) {
			e.printStackTrace();			
		}
		
		return alunos;
	}
	
}
