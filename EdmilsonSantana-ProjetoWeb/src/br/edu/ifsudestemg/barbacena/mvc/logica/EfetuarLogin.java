package br.edu.ifsudestemg.barbacena.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.barbacena.ifsudestemg.daw.dao.UsuarioDAO;
import br.edu.barbacena.ifsudestemg.daw.modelo.Usuario;

public class EfetuarLogin implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String url = "login.jsp";
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.validaCredencial(login, senha);
		
		if(usuario != null) {
			HttpSession sessao = request.getSession();
			sessao.setMaxInactiveInterval(2*60);
			sessao.setAttribute("status", true);
			sessao.setAttribute("nome", login);
			url = "menu-principal.jsp";
		}
		
		return url;
	}

}
