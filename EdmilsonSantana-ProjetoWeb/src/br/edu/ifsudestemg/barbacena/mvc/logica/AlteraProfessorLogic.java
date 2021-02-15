package br.edu.ifsudestemg.barbacena.mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.barbacena.ifsudestemg.daw.dao.ProfessorDAO;
import br.edu.barbacena.ifsudestemg.daw.modelo.Professor;

public class AlteraProfessorLogic implements Logica{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
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
		
		RequestDispatcher rd = request.getRequestDispatcher("/lista-professores-elegante.jsp");
		rd.forward(request, response);
		
		
	}

}
