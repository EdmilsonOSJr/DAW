package br.edu.ifsudestemg.barbacena.visitacao.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsudestemg.barbacena.visitacao.dao.AgendamentoDAO;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Agendamento;

public class RemoverAgendamento implements Logica{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
		
		String codConfirmacao = request.getParameter("codConfirmacao");
		
		Agendamento agendamento = new Agendamento();
		agendamento.setCodConfirmacao(codConfirmacao);
		
		AgendamentoDAO dao = new AgendamentoDAO();
		dao.remover(agendamento);
		
		return "cancelamento-pt1.jsp";
	}
	
}
