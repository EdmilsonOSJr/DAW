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
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		long valor = 15;
		
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
		while(valor>=0){
			out.println("<tr>");
			out.println("<td>");
			out.println(valor);
			out.println("</td>");
			out.println("<td>");
			out.println(calculaFatorial(valor));
			out.println("</td>");
			out.println("</tr>");
			valor--;
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
