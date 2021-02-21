package br.edu.ifsudestemg.barbacena.visitacao.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidaQtd implements Logica{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
		String url = "agendamento-pt3.jsp";
		
		System.out.println("teste");
		
		Long numVagas = Long.parseLong(request.getParameter("vagas"));
		Long numPessoa = Long.parseLong(request.getParameter("numPessoas"));
		Long cod = Long.parseLong(request.getParameter("codMuseu"));
		
		System.out.println(numPessoa);
		System.out.println(numVagas);
		System.out.println(cod);
		
		if(numPessoa>numVagas)
			url = "agendamendo-pt2.jsp";
	
		
		return url;
	}
	
}
