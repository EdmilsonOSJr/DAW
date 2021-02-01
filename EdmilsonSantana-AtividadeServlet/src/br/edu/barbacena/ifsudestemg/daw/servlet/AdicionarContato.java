package br.edu.barbacena.ifsudestemg.daw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.java.AgendaContatos;
import modelo.java.Contato;


@WebServlet("/adicionarContato")
public class AdicionarContato extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Contato contato = new Contato();
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setTelefone(telefone);
		
		AgendaContatos agenda = new AgendaContatos();
		agenda.adicionaContato(contato);
		
		out.println("O contato "+contato.getNome()+" foi adicionado com sucesso.");
		
	}
}
