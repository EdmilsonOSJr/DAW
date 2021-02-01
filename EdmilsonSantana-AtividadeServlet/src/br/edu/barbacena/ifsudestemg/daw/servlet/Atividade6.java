package br.edu.barbacena.ifsudestemg.daw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/atividade6")
public class Atividade6 extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String pesoTexto = request.getParameter("peso");
		String alturaTexto = request.getParameter("altura");
		double peso = 0;
		double altura = 0;
		Double imc = 0.0;
		
		try {
			
			peso = Double.parseDouble(pesoTexto);
			altura = Double.parseDouble(alturaTexto);
			
		} catch (Exception e) {
			out.println("Dados inválidos.");
			return;
		}
		
		
		imc = peso/Math.pow(altura,2);

		if(imc<18.5) {
			out.println("=> Cuidado! Você está muito abaixo do peso!");
		}else if(18.5 <= imc && imc < 25.0) {
			out.println("=> Parabéns! Você está em seu peso ideal!\r\n");
		}else if(25.0 <= imc && imc < 30.0) {
			out.println("=> Atenção! Você está acima de seu peso ideal!");
		}else if(30.0 <= imc && imc < 35.0) {
			out.println("=> Atenção! Obesidade grau 1!");
		}else if(35.5 <= imc && imc < 40.0) {
			out.println("=> Cuidado! Obesidade grau 2!");
		}else {
			out.println("=> Cuidado! Obesidade grau 3!");
		}
			
		
	}
}
