package br.edu.ifsudestemg.barbacena.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EfetuaLogout implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession sessao = request.getSession(false);
		
		sessao.invalidate();
		
		return "login.jsp";
	}

}
