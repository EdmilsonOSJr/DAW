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

@WebServlet("/pesquisarContato")
public class PesquisarContato extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
	
		int indiceContato = agenda.pesquisarContato(nome);
		
		if(indiceContato==-1)
			out.println("O contato não foi encontrado.");
		else {
			
			List<Contato> contatos = agenda.listaContatos();
			out.println("<html");
			out.println("<body");
			out.println("<br>Contato encontrado:<br\\>");
			out.println("<br>"+contatos.get(indiceContato).getNome()+"<br\\>");
			out.println("<br>"+contatos.get(indiceContato).getEmail()+"<br\\>");
			out.println("<br>"+contatos.get(indiceContato).getTelefone()+"<br \\>");
			out.println("</body");
			out.println("</html");
		}
			
				
	}
}
