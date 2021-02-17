package br.edu.ifsudestemg.barbacena.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.barbacena.ifsudestemg.daw.dao.ProfessorDAO;
import br.edu.barbacena.ifsudestemg.daw.modelo.Professor;

public class AlteraProfessorLogic implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String grauFormacao = request.getParameter("grauFormacao");
		
		
		Professor professor = new Professor();
		professor.setId(id);
		professor.setNome(nome);
		professor.setEmail(email);
		professor.setGrauFormacao(grauFormacao);
		
		ProfessorDAO dao = new ProfessorDAO();
		
		dao.altera(professor);
		
		return "lista-professores-elegante.jsp";
		
		
	}

}
