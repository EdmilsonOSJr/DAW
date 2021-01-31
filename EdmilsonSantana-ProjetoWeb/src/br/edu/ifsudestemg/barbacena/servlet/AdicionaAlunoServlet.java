package br.edu.ifsudestemg.barbacena.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.barbacena.ifsudestemg.daw.dao.AlunoDAO;
import br.edu.barbacena.ifsudestemg.daw.modelo.Aluno;


@WebServlet("/adicionaAluno")
public class AdicionaAlunoServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataNascimentoTexto = request.getParameter("dataNascimento");
		System.out.println(dataNascimentoTexto);
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
		
		
		out.println("<html>");
		out.println("<body>");
		out.println("O(a) aluno(a) "+nome+" foi adicionado com sucesso.");
		out.println("</body");
		out.println("</html>");
				
	}

}
