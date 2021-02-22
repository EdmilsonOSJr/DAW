package br.edu.ifsudestemg.barbacena.visitacao.teste;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestarConexao {

	public static void main(String[] args) throws ParseException, SQLException {

		
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println(df.format(c.getTime()));
		
	}
}
