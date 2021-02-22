package br.edu.ifsudestemg.barbacena.visitacao.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsudestemg.barbacena.visitacao.dao.AgendamentoDAO;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Agendamento;

public class ValidaCancelamento implements Logica{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
	
		String url = "cancelamento-pt2.jsp";
		String codConfirmacao = request.getParameter("codConfirmacao");
			
		AgendamentoDAO dao = new AgendamentoDAO();
		
		
		Agendamento agendamento = dao.recupera(codConfirmacao);
		
		if(agendamento == null)
			url = "cancelamento-pt1.jsp";
				
		
		return url;
	}
	
}
