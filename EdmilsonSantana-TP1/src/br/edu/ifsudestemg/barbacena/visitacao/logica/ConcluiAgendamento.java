package br.edu.ifsudestemg.barbacena.visitacao.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsudestemg.barbacena.visitacao.dao.AgendamentoDAO;
import br.edu.ifsudestemg.barbacena.visitacao.dao.PessoaDAO;
import br.edu.ifsudestemg.barbacena.visitacao.dao.VisitanteDAO;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Agendamento;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Pessoa;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Visitante;
import br.edu.ifsudestemg.barbacena.visitacao.util.EmailVisitacao;
import br.edu.ifsudestemg.barbacena.visitacao.util.GerarCodConfirmacao;
import br.edu.ifsudestemg.barbacena.visitacao.util.ValidaCPF;

public class ConcluiAgendamento implements Logica {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {

		Long numPessoas = Long.parseLong(request.getParameter("numPessoas"));
		String emailTxt = request.getParameter("email");
		String dataTxt = request.getParameter("data");
		Long hora= Long.parseLong(request.getParameter("hora"));
		Long codMuseu = Long.parseLong(request.getParameter("codMuseu"));
		String nome;
		String cpf;
		String tipoIngresso;
		String message , subject = "Agendamento realizado com sucesso.";

		Date datad;

		try {
			datad = new SimpleDateFormat("yyyy-MM-dd").parse(dataTxt);

			Calendar datac = Calendar.getInstance();
			datac.setTime(datad);

			Visitante visitante;
			Pessoa pessoa;

			AgendamentoDAO daoAgendamento = new AgendamentoDAO();
			VisitanteDAO daoVisitante = new VisitanteDAO();
			PessoaDAO daoPessoa = new PessoaDAO();
			
			String codConfirmacao = GerarCodConfirmacao.Hash(emailTxt+dataTxt+hora+codMuseu);
			
			Agendamento agendamento = daoAgendamento.recupera(codConfirmacao);
			
			if(agendamento!=null) // o email é único 
				return "agendamento-pt1.jsp";
			
			
			// valida o cpf informado
			for (int i = 1; i <= numPessoas; i++) {
				cpf = request.getParameter("cpf"+i);
				if(!validaCpfVisitantes(cpf))
					return "agendamento-pt1.jsp";
			}
			
			
			agendamento = new Agendamento();
			agendamento.setCodConfirmacao(codConfirmacao);
			agendamento.setCodMuseu(codMuseu);
			agendamento.setDataVisitacao(datac);
			agendamento.setHora(hora);
			agendamento.setEmail(emailTxt);
			daoAgendamento.adiciona(agendamento);
			message = String.format("O agendametno para o dia %s às %d horas foi realizado com sucesso. %d pessoas foram agendadas, sendo elas:\n", dataTxt, 
					hora,numPessoas);

			for (int i = 1; i <= numPessoas; i++) {
				nome = request.getParameter("nome"+i);
				cpf = request.getParameter("cpf"+i);
				tipoIngresso = request.getParameter("tipoIngresso"+i);
				
				if(!ValidaCPF.valida(cpf)) {
					return "agendamento-pt1.jsp";
				}
				
				message+="\n\t"+cpf+"  "+nome;
				
				pessoa = daoPessoa.recupera(cpf);
				if(pessoa==null) {// cpf é único
					pessoa = new Pessoa();
					pessoa.setCpf(cpf);
					pessoa.setNome(nome);
					daoPessoa.adiciona(pessoa);
				}
				
				
				visitante = new Visitante();
				visitante.setCpf(cpf);
				visitante.setTipoIngresso(tipoIngresso);
				visitante.setIdAgendamento(daoAgendamento.recupera(codConfirmacao).getId());

				daoVisitante.adiciona(visitante);				
			}

			message+="\n\n"+codConfirmacao;
			
			EmailVisitacao email = new EmailVisitacao(emailTxt,subject,message);
			email.enviar();
			
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		
		return "agendamento-concluido.jsp";
	}
	
	private boolean validaCpfVisitantes(String cpf) {
		
		return ValidaCPF.valida(cpf);
	}
	
}
