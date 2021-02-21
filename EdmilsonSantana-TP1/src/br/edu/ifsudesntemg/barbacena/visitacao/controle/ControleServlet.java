package br.edu.ifsudesntemg.barbacena.visitacao.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsudestemg.barbacena.visitacao.logica.Logica;

@WebServlet("/mvc")
public class ControleServlet extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String parametro = request.getParameter("logica");
		String nomeDaClasse = "br.edu.ifsudestemg.barbacena.visitacao.logica."+parametro;
		String url = "login.jsp";
		
		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			Logica logica = (Logica) classe.newInstance();
			url = logica.service(request, response);
		} catch (Exception e) {
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}
}
