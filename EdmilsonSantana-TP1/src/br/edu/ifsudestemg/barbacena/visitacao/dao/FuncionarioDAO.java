package br.edu.ifsudestemg.barbacena.visitacao.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsudestemg.barbacena.visitacao.jdbc.ConnectionFactory;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Funcionario;

public class FuncionarioDAO {

	private Connection connection;
	
	public FuncionarioDAO() {
		
		connection = ConnectionFactory.getConnection();
	}
	
		
	public void adiciona(Funcionario funcionario) {
		String sql = "Insert into funcionario (nome,cpf,idMuseu) values(?,?,?)";
		
		try {
			 PreparedStatement stmt = connection.prepareStatement(sql);
			 stmt.setString(1, funcionario.getNome());
			 stmt.setString(2, funcionario.getCpf());
			 stmt.setLong(3, funcionario.getIdMuseu());
			 
			 stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
//	public void altera(Usuario usuario) {
//		String sql = "update usuario set senha=? where login=?";
//		
//		try {
//			
//			PreparedStatement stmt = connection.prepareStatement(sql);
//			stmt.setString(1, usuario.getSenha());
//			stmt.setString(2, usuario.getLogin());
//			stmt.execute();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
//	public void remover(String login) {
//		String sql = "delete from usuario where login=?";
//		
//		try {
//			PreparedStatement stmt = connection.prepareStatement(sql);
//			stmt.setString(1, login);
//			stmt.execute();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	public Funcionario recuperarFuncionario(String cpf) {
		
		String sql = "select * from funcionario where cpf=?";
		Funcionario funcionario= null;
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				funcionario = new Funcionario();
				funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setIdMuseu(rs.getLong("idMuseu"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return funcionario; 
		
	}
	
public Funcionario recuperarFuncionarioId(String id) {
		
		String sql = "select * from funcionario where id=?";
		Funcionario funcionario= null;
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1,Long.parseLong(id));
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				funcionario = new Funcionario();
				funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setIdMuseu(rs.getLong("idMuseu"));
			}
			
			System.out.println(funcionario.getIdMuseu());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return funcionario; 
		
	}
	
//	
//	public Usuario validaCredencial(String login, String senha) {
//		String sql = "select * from usuario where login=? and senha=?";
//		Usuario usuario = null;
//		
//		try(PreparedStatement stmt = connection.prepareStatement(sql)){
//				
//			stmt.setString(1, login);
//			stmt.setString(2, senha);
//			ResultSet rs = stmt.executeQuery();
//			
//			while(rs.next()) {
//				usuario = new Usuario();
//				usuario.setLogin(rs.getString("login"));
//				usuario.setSenha(rs.getString("senha"));
//			}
//			
//		}catch (SQLException e) {
//			// TODO: handle exception
//		}
//		
//		return usuario;
//	}
//	
	
	public List<Funcionario> listaFuncionarios(){
		
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		String sql = "select * from funcionario";
		
		Funcionario funcionario = null;
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				funcionario = new Funcionario();
				funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setIdMuseu(rs.getLong("idMuseu"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return funcionarios;
	}
}
