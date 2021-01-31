package br.edu.barbacena.ifsudestemg.daw.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.barbacena.ifsudestemg.daw.jdbc.ConnectionFactory;

public class TestaConexao {
	
	public static void main(String[] args) {
		try {
		
			Connection connection = ConnectionFactory.getConection();
			System.out.println("Conexão aberta");
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
