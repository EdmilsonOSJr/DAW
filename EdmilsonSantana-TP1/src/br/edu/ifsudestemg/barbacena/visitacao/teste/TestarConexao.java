package br.edu.ifsudestemg.barbacena.visitacao.teste;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestarConexao {

	public static void main(String[] args) throws ParseException, SQLException {

		
		Calendar c = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		c2.setTime(new SimpleDateFormat("dd/MM/yyyy").parse("28/02/2021"));
		
		System.out.println(df.format(c.getTime()));
		System.out.println(df.format(c2.getTime()));
		
		System.out.println(c.compareTo(c2));
	}
}
