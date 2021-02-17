package br.edu.ifsudestemg.barbacena.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.barbacena.ifsudestemg.daw.dao.ProfessorDAO;
import br.edu.barbacena.ifsudestemg.daw.modelo.Professor;

public class AdicionaProfessorLogic implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String grauFormacao = request.getParameter("grauFormacao");
		
		Professor professor = new Professor();
		professor.setNome(nome);
		professor.setEmail(email);
		professor.setGrauFormacao(grauFormacao);
		
		new ProfessorDAO().adiciona(professor);
		
		return "professor-adicionado.jsp";
				
	}
	
}
