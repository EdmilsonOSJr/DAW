package br.edu.ifsudestemg.barbacena.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.barbacena.ifsudestemg.daw.dao.ProfessorDAO;
import br.edu.barbacena.ifsudestemg.daw.modelo.Professor;

@WebServlet("/adicionaProfessor")
public class AdicionaProfessorServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String grauFormacao = request.getParameter("grauFormacao");
		
		Professor professor = new Professor();
		professor.setNome(nome);
		professor.setEmail(email);
		professor.setGrauFormacao(grauFormacao);
		
		new ProfessorDAO().adiciona(professor);
		
		out.println("<html>");
		out.println("<body>");
		out.println("O(a) professor "+nome+" foi adicionado com sucesso.");
		out.println("</body>");
		out.println("</html>");
		
	}
}
