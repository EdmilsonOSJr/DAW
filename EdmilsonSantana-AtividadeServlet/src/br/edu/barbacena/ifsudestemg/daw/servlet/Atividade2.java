package br.edu.barbacena.ifsudestemg.daw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/atividade2")
public class Atividade2 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

PrintWriter out = response.getWriter();
		
		Enumeration<String> nomesHeaders = request.getHeaderNames();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<table border=\"1\" width=\"200\">");
		out.println("<tr>");
		out.println("<td>");
		out.println("Parametro");
		out.println("</td>");
		out.println("<td>");
		out.println("Valor");
		out.println("</td>");
		out.println("</tr>");
		while(nomesHeaders.hasMoreElements()) {
			String header = (String)nomesHeaders.nextElement();
			Enumeration<String> val =request.getHeaders(header);
			String value = (String)val.nextElement();
			
			out.println("<tr>");
			out.println("<td>");
			out.println(header);
			out.println("</td>");
			out.println("<td>");
			out.println(value);
			out.println("</td>");
			out.println("</tr>");
		}		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	
	}
	
}
