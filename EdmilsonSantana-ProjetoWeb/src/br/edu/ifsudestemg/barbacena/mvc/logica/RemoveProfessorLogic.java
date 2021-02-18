package br.edu.ifsudestemg.barbacena.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.barbacena.ifsudestemg.daw.dao.ProfessorDAO;
import br.edu.barbacena.ifsudestemg.daw.modelo.Professor;

public class RemoveProfessorLogic implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		Professor professor = new Professor();
		professor.setId(id);
		
		ProfessorDAO dao = new ProfessorDAO();
		
		dao.remove(professor);
		
		return "lista-professores-elegante.jsp";
	}

}
