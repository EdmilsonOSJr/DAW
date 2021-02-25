package br.edu.ifsudestemg.barbacena.visitacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsudestemg.barbacena.visitacao.jdbc.ConnectionFactory;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Pessoa;

public class PessoaDAO {

	private Connection connection;

	public PessoaDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public void adiciona(Pessoa pessoa) {
		String sql = "insert into pessoa (cpf,nome) values (?,?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, pessoa.getCpf());
			stmt.setString(2, pessoa.getNome());
			stmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public Pessoa recupera(String cpf){
		
		String sql = "select * from pessoa where cpf=?";
		
		Pessoa a = null;
		
		try (PreparedStatement stmt = connection.prepareStatement(sql);){
			
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			
			a = new Pessoa();
			a.setNome(rs.getString("nome"));
			a.setCpf(rs.getString("cpf"));
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}
	
	
	
	
	public List<Pessoa> lista(String cpf) {

		String sql = "select * from pessoa where cpf=?";
		Pessoa pessoa = null;
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				pessoa = new Pessoa();
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setNome(rs.getString("nome"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pessoas;
	}

}
