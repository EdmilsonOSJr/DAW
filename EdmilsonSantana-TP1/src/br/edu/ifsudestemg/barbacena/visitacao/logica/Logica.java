package br.edu.ifsudestemg.barbacena.visitacao.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	
	public String service(HttpServletRequest request, HttpServletResponse response);

}
