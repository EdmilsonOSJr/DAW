package br.edu.ifsudestemg.barbacena.visitacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifsudestemg.barbacena.visitacao.jdbc.ConnectionFactory;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Permissao;

public class PermissaoDAO {

	Connection connection;

	public PermissaoDAO() {

		connection = ConnectionFactory.getConnection();
	}

	public void adiciona(Permissao permissao) {
		String sql = "Insert into permissao (nome) values(?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, permissao.getNome());

			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Permissao recuperarPermissao(String nome) {

		String sql = "select * from permissao where nome=?";
		Permissao permissao = null;

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				permissao = new Permissao();
				permissao.setNome(rs.getString("nome"));
				permissao.setId(rs.getLong("id"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return permissao;

	}
	
	public Permissao recuperarPermissao(Long id) {
		
		String sql = "select * from permissao where id=?";
		Permissao permissao = null;
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				permissao = new Permissao();
				permissao.setNome(rs.getString("nome"));
				permissao.setId(rs.getLong("id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return permissao;
		
	}

}
