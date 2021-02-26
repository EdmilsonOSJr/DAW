package br.edu.ifsudestemg.barbacena.visitacao.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifsudestemg.barbacena.visitacao.dao.UsuarioDAO;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Usuario;


public class EfetuarLogin implements Logica{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String url = "login.jsp";
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.validaCredencial(login, senha);
		
		if(usuario != null) {
			HttpSession sessao = request.getSession();
			
			if(usuario.getPermissao()==1) {
				sessao.setAttribute("permissao", usuario.getPermissao());
				url = "cadastro_funcionario.jsp";
			} else {
				sessao.setAttribute("permissao", usuario.getPermissao());
				sessao.setAttribute("idFuncionario", usuario.getIdFuncionario());
				url = "menu_funcionário.jsp";
				
			}
			
			sessao.setMaxInactiveInterval(2*60);
			sessao.setAttribute("status", true);
			sessao.setAttribute("nome", login);
		}
		
		return url;
	}
	
}	
