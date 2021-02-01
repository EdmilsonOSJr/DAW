package br.edu.barbacena.ifsudestemg.daw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.java.AgendaContatos;
import modelo.java.Contato;


@WebServlet("/listarContato")
public class ListarContato extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		List<Contato> contatos = new ArrayList<>();
		
		contatos = new AgendaContatos().listaContatos();
		
		out.println("<html");
		out.println("<body");
		for(Contato contato: contatos) {
			out.println(contato);
		}
		out.println("</body");
		out.println("</html");
		
	}
}
