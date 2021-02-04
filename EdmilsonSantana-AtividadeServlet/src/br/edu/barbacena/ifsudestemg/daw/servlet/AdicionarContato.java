package br.edu.barbacena.ifsudestemg.daw.servlet;

import java.io.IOException;




import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.barbacena.ifsudeste.daw.modelo.Contato;

import static br.edu.barbacena.ifsudestemg.daw.servlet.Atividade7.agenda;


@WebServlet("/adicionarContato")
public class AdicionarContato extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		
		if(nome.isEmpty()) {
			out.println("Forneça um nome");
			return;
		}
		
		Contato contato = new Contato(nome,email,telefone);
		
		boolean contatoVálido = agenda.adicionaContato(contato);
		
		if(contatoVálido)
			out.println("O contato "+contato.getNome()+" foi adicionado com sucesso.");
		else
			out.println("O contato "+contato.getNome()+" já existe.");
		
	}
}
