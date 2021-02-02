package br.edu.barbacena.ifsudestemg.daw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.java.AgendaContatos;

@WebServlet("/menu")
public class MenuAtividade7 extends HttpServlet{

	public static AgendaContatos agenda = new AgendaContatos();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
