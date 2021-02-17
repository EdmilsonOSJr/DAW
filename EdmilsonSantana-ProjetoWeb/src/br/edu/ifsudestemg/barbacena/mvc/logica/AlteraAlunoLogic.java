package br.edu.ifsudestemg.barbacena.mvc.logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.barbacena.ifsudestemg.daw.dao.AlunoDAO;
import br.edu.barbacena.ifsudestemg.daw.modelo.Aluno;

public class AlteraAlunoLogic implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Aluno aluno = new Aluno();
		long id = Long.parseLong(request.getParameter("id"));
		aluno.setId(id);
		aluno.setNome(request.getParameter("nome"));
		aluno.setEndereco(request.getParameter("endereco"));
		aluno.setEmail(request.getParameter("email"));

		// Converte a data de String para Calendar
		String dataEmTexto = request.getParameter("dataNascimento");
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(date);
		aluno.setDataNascimento(dataNascimento);
		AlunoDAO dao = new AlunoDAO();
		dao.altera(aluno);
		
		System.out.println("Alterando aluno ..." + aluno.getNome());
		
		return "lista-alunos-elegante.jsp";
	}
	

}
