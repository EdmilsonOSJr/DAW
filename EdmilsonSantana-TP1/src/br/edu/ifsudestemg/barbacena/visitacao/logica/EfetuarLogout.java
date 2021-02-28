package br.edu.ifsudestemg.barbacena.visitacao.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class EfetuarLogout implements Logica{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession sessao = request.getSession(false);
		
		sessao.invalidate();
		
		return "login.jsp";
	}
}
