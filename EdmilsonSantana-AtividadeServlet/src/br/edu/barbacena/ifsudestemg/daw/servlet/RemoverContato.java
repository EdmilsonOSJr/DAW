package br.edu.barbacena.ifsudestemg.daw.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static br.edu.barbacena.ifsudestemg.daw.servlet.Atividade7.agenda;

@WebServlet("/removerContato")
public class RemoverContato extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		
		boolean contatoRemovido = agenda.removeContato(nome);
		
		if(contatoRemovido)
			out.println("O contato "+nome+" foi removido com sucesso.");
		else
			out.println("O Contato não existe");
		
	}
}
