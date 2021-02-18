package br.edu.ifsudestemg.barbacena.mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.barbacena.ifsudestemg.daw.dao.ProfessorDAO;
import br.edu.barbacena.ifsudestemg.daw.modelo.Professor;

public class AdicionaProfessorLogic implements Logica{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String grauFormacao = request.getParameter("grauFormacao");
		
		Professor professor = new Professor();
		professor.setNome(nome);
		professor.setEmail(email);
		professor.setGrauFormacao(grauFormacao);
		
		new ProfessorDAO().adiciona(professor);
		
		RequestDispatcher rd = request.getRequestDispatcher("/professor-adicionado.jsp");
		rd.forward(request, response);
		
	}
	
}
