package br.edu.ifsudestemg.barbacena.visitacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsudestemg.barbacena.visitacao.jdbc.ConnectionFactory;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Museu;

public class MuseuDAO {
	
	private Connection connection;

	public MuseuDAO() {
		connection = ConnectionFactory.getConnection();
	}
	
	
	public Museu recupera(String id) {
		String sql = "select * from museu where id=?";
		Museu museu = null;
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, Long.parseLong(id));
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				museu = new Museu();
				
				museu.setId(rs.getLong("id"));
				museu.setNome(rs.getString("nome"));
				museu.setNumVisitantes(rs.getLong("numVisitantes"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return museu;
		
	}
	
	
	public List<Museu> lista(){
		String sql = "select * from museu";
		
		List<Museu> museus = new ArrayList<Museu>();
		Museu museu = null;
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				museu = new Museu();
				
				museu.setId(rs.getLong("id"));
				museu.setNome(rs.getString("nome"));
				museu.setNumVisitantes(rs.getLong("numVisitantes"));
				
				museus.add(museu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return museus;
		
	}
	
	

}
