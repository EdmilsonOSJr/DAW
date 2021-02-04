package br.edu.barbacena.ifsudestemg.daw.servlet;

import static br.edu.barbacena.ifsudestemg.daw.servlet.Atividade7.agenda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.barbacena.ifsudeste.daw.modelo.Contato;

@WebServlet("/listarContato")
public class ListarContato extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		List<Contato> cont = agenda.listaContatos();
		
		out.println("<html");
		out.println("<body");
		for(Contato contato: cont) {
			out.println("<br>"+contato.getNome()+"<br\\>");
			out.println("<br>"+contato.getEmail()+"<br\\>");
			out.println("<br>"+contato.getTelefone()+"<br \\>");
		}
		out.println("</body");
		out.println("</html");
		
	}
}
