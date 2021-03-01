package br.edu.ifsudestemg.barbacena.visitacao.util;

import java.security.MessageDigest;

public class GerarCodConfirmacao {

	public static String Hash(String senha) throws Exception {
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte hash[] = algorithm.digest(senha.getBytes("UTF-8"));

		StringBuilder texto = new StringBuilder();
		for (byte b : hash) {
			texto.append(String.format("%02X", 0xFF & b));
		}
		return texto.toString();
	}
	
}
