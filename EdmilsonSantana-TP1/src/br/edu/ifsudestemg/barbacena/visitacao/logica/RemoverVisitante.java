package br.edu.ifsudestemg.barbacena.visitacao.logica;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsudestemg.barbacena.visitacao.dao.AgendamentoDAO;
import br.edu.ifsudestemg.barbacena.visitacao.dao.PessoaDAO;
import br.edu.ifsudestemg.barbacena.visitacao.dao.VisitanteDAO;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Agendamento;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Visitante;
import br.edu.ifsudestemg.barbacena.visitacao.util.EmailVisitacao;

public class RemoverVisitante implements Logica{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {

		String cpf = request.getParameter("cpf");
		String cod = request.getParameter("codConfirmacao");
		String subject = "Atualização de agendamento";
		String message = null;
		String url = "cancelamento-pt2.jsp?codConfirmacao="+cod;
		
		// Remove o visitante
		VisitanteDAO daoVisitante = new VisitanteDAO();
		Visitante visitante = new Visitante();
		visitante.setCpf(cpf);
		daoVisitante.remover(visitante);
		
		
		
		AgendamentoDAO daoAgendamento = new AgendamentoDAO();
		Agendamento agendamento = new Agendamento();
		agendamento = daoAgendamento.recupera(cod);
		
		
		PessoaDAO daoPessoa = new PessoaDAO();
		

		List<Visitante> visitantes = new ArrayList<>();
		visitantes = daoVisitante.lista(agendamento.getId());
		
		// Caso o visitante removido seja o último o agendamento também é excluido.
		if(visitantes.size()==0) {
			daoAgendamento.remover(agendamento);
			url = "cancelamento-pt1.jsp";
		}
		
		// Constroi mensagem.
		String datatxt = new SimpleDateFormat("yyyy-MM-dd").format(agendamento.getDataVisitacao().getTime());
		Long hora = agendamento.getHora();
		Long codMuseu = agendamento.getCodMuseu();
		String emailtxt = agendamento.getEmail();
		
		message = String.format("O agendamento do dia %s às %d horas foi atualizado, estando agora com %d visitantes, sendo eles:\n",datatxt,hora,
				daoAgendamento.numPessoas(datatxt,hora,codMuseu));
		
		for(Visitante vis: visitantes) {
			message+="\n\t"+vis.getCpf()+"   "+daoPessoa.recupera(vis.getCpf()).getNome();
		}
		
		message+="\n\n"+cod;
		
		EmailVisitacao email = new EmailVisitacao(emailtxt,subject,message);
		email.enviar();
		
		return url;
		
	}
	
}
