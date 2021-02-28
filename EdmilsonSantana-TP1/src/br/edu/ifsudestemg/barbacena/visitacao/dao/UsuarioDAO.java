package br.edu.ifsudestemg.barbacena.visitacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsudestemg.barbacena.visitacao.jdbc.ConnectionFactory;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Usuario;

public class UsuarioDAO {

	Connection connection;
	
	public UsuarioDAO() {
		
		connection = ConnectionFactory.getConnection();
	}
	
	
	public void adiciona(Usuario usuario) {
		String sql = "Insert into usuario (login,senha,permissao,idFuncionario) values(?,?,?,?)";
		
		try {
			 PreparedStatement stmt = connection.prepareStatement(sql);
			 stmt.setString(1,usuario.getLogin());
			 stmt.setString(2, usuario.getSenha());
			 stmt.setLong(3, usuario.getPermissao());
			 stmt.setLong(4, usuario.getIdFuncionario());
			 
			 stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void altera(Usuario usuario) {
		String sql = "update usuario set senha=? where login=?";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getSenha());
			stmt.setString(2, usuario.getLogin());
			stmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remover(String login) {
		String sql = "delete from usuario where login=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, login);
			stmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Usuario recuperarUsuario(String login) {
		
		String sql = "select * from usuario where login=?";
		Usuario usuario = null;
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, login);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setIdFuncionario(rs.getLong("idFuncionario"));
				usuario.setPermissao(rs.getLong("permissao"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuario; 
		
	}
	
	public Usuario validaCredencial(String login, String senha) {
		String sql = "select * from usuario where login=? and senha=?";
		Usuario usuario = null;
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
				
			stmt.setString(1, login);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setPermissao(rs.getLong("permissao"));
				usuario.setIdFuncionario(rs.getLong("idFuncionario"));
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
		}
		
		return usuario;
	}
	
	
	public List<Usuario> listaUsuarios(){
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		String sql = "select * from usuario";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setIdFuncionario(rs.getLong("idFuncionaio"));
				usuario.setIdFuncionario(rs.getLong("id"));
				usuarios.add(usuario);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return usuarios;
	}
	
}
