package br.edu.ifsudestemg.barbacena.visitacao.logica;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsudestemg.barbacena.visitacao.dao.AgendamentoDAO;
import br.edu.ifsudestemg.barbacena.visitacao.dao.FuncionarioDAO;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Agendamento;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Funcionario;

public class ValidaCancelamento implements Logica{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
	
		String url = "cancelamento-pt2.jsp";
		String codConfirmacao = request.getParameter("codConfirmacao");
		String idFuncionario = request.getParameter("idFuncionario");
			
		Calendar dataAtual = Calendar.getInstance();
		
		AgendamentoDAO dao = new AgendamentoDAO();
		Agendamento agendamento = dao.recupera(codConfirmacao);
		
		if(agendamento == null)
			url = "cancelamento-pt1.jsp";
		else {
			
			if(idFuncionario != null) {
				
				FuncionarioDAO daoFuncionario = new FuncionarioDAO();
				Funcionario funcionario = daoFuncionario.recuperarFuncionarioId(idFuncionario);
				
				if(agendamento.getCodMuseu()!=funcionario.getIdMuseu())
					url = "cancelamento-pt1.jsp";
				
			}
			
			
			if(agendamento.getDataVisitacao().compareTo(dataAtual)<=0) // Só cancelamentos após a data atual podem ser cancelados.
				url = "cancelamento-pt1.jsp";
			
			
		}
			
		
		
		return url;
	}
	
}
