package br.edu.ifsudestemg.barbacena.visitacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsudestemg.barbacena.visitacao.jdbc.ConnectionFactory;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Visitante;

public class VisitanteDAO {

	private Connection connection;

	public VisitanteDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public void adiciona(Visitante visitante) {
		String sql = "insert into visitante (cpf,tipoIngresso,idAgendamento) values (?,?,?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, visitante.getCpf());
			stmt.setString(2, visitante.getTipoIngresso());
			stmt.setLong(3, visitante.getIdAgendamento());
			stmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void remover(Visitante visitante) {
		String sql = "delete from visitante where cpf=?";
		
		
		try(PreparedStatement stmt = connection.prepareStatement(sql) ){
			stmt.setString(1, visitante.getCpf());
			stmt.execute();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Visitante> lista() {

		String sql = "select * from visitante";
		Visitante visitante = null;
		List<Visitante> visitantes = new ArrayList<Visitante>();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				visitante = new Visitante();
				visitante.setId(rs.getLong("id"));
				visitante.setCpf(rs.getString("cpf"));
				visitante.setIdAgendamento(rs.getLong("idAgendamento"));
				visitante.setTipoIngresso(rs.getString("tipoIngresso"));
				visitantes.add(visitante);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return visitantes;
	}

	public List<Visitante> lista(Long id) {

		String sql = "select * from visitante where idAgendamento=?";
		Visitante visitante = null;
		List<Visitante> visitantes = new ArrayList<Visitante>();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				visitante = new Visitante();
				visitante.setId(rs.getLong("id"));
				visitante.setCpf(rs.getString("cpf"));
				visitante.setIdAgendamento(rs.getLong("idAgendamento"));
				visitante.setTipoIngresso(rs.getString("tipoIngresso"));
				visitantes.add(visitante);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return visitantes;
	}

}
