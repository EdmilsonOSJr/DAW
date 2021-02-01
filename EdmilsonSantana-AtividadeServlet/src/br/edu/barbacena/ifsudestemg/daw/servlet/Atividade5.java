package br.edu.barbacena.ifsudestemg.daw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/atividade5")
public class Atividade5 extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String maximoTexto = request.getParameter("maximo");
		
		long maximo = 0;
		
		try {
			maximo = Long.parseLong(maximoTexto);
		} catch (NullPointerException|NumberFormatException e) {
			out.println("Valor invãlido.");
			return;
		}
		
		out.println("<html>");
		out.println("<body>");
		out.println("<table border=\"1\" width=\"200\">");
		out.println("<tr>");
		out.println("<td>");
		out.println("Número");
		out.println("</td>");
		out.println("<td>");
		out.println("Fatorial");
		out.println("</td>");
		out.println("</tr>");
		while(maximo>=0){
			out.println("<tr>");
			out.println("<td>");
			out.println(maximo);
			out.println("</td>");
			out.println("<td>");
			out.println(calculaFatorial(maximo));
			out.println("</td>");
			out.println("</tr>");
			maximo--;
		}
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	
		
	}
	
	public long calculaFatorial(long valor) {
		if(valor==0)
			return 1;
		return valor * calculaFatorial(valor-1);
	}
	

}
