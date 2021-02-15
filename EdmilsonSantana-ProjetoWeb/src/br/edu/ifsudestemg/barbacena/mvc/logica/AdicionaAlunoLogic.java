package br.edu.ifsudestemg.barbacena.mvc.logica;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.barbacena.ifsudestemg.daw.dao.AlunoDAO;
import br.edu.barbacena.ifsudestemg.daw.modelo.Aluno;

public class AdicionaAlunoLogic implements Logica{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataNascimentoTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimentoTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			out.println("Erro de conversão da data");
			return; // para a execução do método

		}
		
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setEmail(email);
		aluno.setEndereco(endereco);
		aluno.setDataNascimento(dataNascimento);
		AlunoDAO dao = new AlunoDAO();
		dao.adiciona(aluno);
		
		RequestDispatcher rd = request.getRequestDispatcher("/aluno-adicionado.jsp");
		rd.forward(request, response);
		
	}

}
