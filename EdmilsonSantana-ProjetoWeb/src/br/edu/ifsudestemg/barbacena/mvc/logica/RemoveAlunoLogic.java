package br.edu.ifsudestemg.barbacena.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.barbacena.ifsudestemg.daw.dao.AlunoDAO;
import br.edu.barbacena.ifsudestemg.daw.modelo.Aluno;

public class RemoveAlunoLogic implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		Aluno aluno = new Aluno();
		aluno.setId(Long.parseLong(id));
		AlunoDAO dao = new AlunoDAO();
		
		dao.remove(aluno);
		
		return "lista-alunos-elegante.jsp";
	}
	
	
}
