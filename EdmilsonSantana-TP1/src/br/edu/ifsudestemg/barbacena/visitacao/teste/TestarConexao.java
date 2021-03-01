package br.edu.ifsudestemg.barbacena.visitacao.teste;

import java.security.MessageDigest;
import java.util.Calendar;

public class TestarConexao {

	public static void main(String[] args) throws Exception {

		
		Calendar dataAtual = Calendar.getInstance();

		int mes = dataAtual.get(Calendar.MONTH)+1;
		int ano = dataAtual.get(Calendar.YEAR);
		int dia = dataAtual.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(dataAtual.get(Calendar.HOUR_OF_DAY));
			
	}

	private static String gerarHash(String senha) throws Exception {
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte hash[] = algorithm.digest(senha.getBytes("UTF-8"));

		StringBuilder texto = new StringBuilder();
		for (byte b : hash) {
			texto.append(String.format("%02X", 0xFF & b));
		}
		return texto.toString();
	}

}
