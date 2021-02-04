package br.edu.barbacena.ifsudestemg.daw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/atividade4")
public class Atividade4 extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		long numero = 10;
		
		out.println("<html>");
		out.println("<body>");
		out.println("<table border=\"1\">");
		out.println("<tr>");
		out.println("<td>");
		out.println("Número");
		out.println("</td>");
		out.println("<td>");
		out.println("Fatorial");
		out.println("</td>");
		out.println("</tr>");
		while(numero>=0){
			out.println("<tr>");
			out.println("<td>");
			out.println(numero);
			out.println("</td>");
			out.println("<td>");
			out.println(fatorial(numero));
			out.println("</td>");
			out.println("</tr>");
			numero--;
		}
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
	
	public long fatorial(long numero) {
		
		if(numero==0)
			return 1;
		
		return numero * fatorial(numero-1);
	}
}
