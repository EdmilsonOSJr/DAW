package br.edu.ifsudestemg.barbacena.visitacao.logica;

import java.security.MessageDigest;
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
import br.edu.ifsudestemg.barbacena.visitacao.modelo.EmailAgendamento;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Pessoa;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Visitante;

public class ConcluiAgendamento implements Logica {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {

		Long numPessoas = Long.parseLong(request.getParameter("numPessoas"));
		String emailtxt = request.getParameter("email");
		String datatxt = request.getParameter("data");
		Long hora= Long.parseLong(request.getParameter("hora"));
		Long codMuseu = Long.parseLong(request.getParameter("codMuseu"));
		String nome;
		String cpf;
		String tipoIngresso;
		String message , subject = "Agendamento realizado com sucesso.";

		Date datad;

		try {
			datad = new SimpleDateFormat("yyyy-MM-dd").parse(datatxt);

			Calendar datac = Calendar.getInstance();
			datac.setTime(datad);

			Visitante visitante;
			Pessoa pessoa;
			Agendamento agendamento;

			AgendamentoDAO daoAgendamento = new AgendamentoDAO();
			VisitanteDAO daoVisitante = new VisitanteDAO();
			PessoaDAO daoPessoa = new PessoaDAO();
			
			String codConfirmacao = gerarHash(emailtxt);
			
			agendamento = new Agendamento();
			agendamento.setCodConfirmacao(codConfirmacao);
			agendamento.setCodMuseu(codMuseu);
			agendamento.setDataVisitacao(datac);
			agendamento.setHora(hora);
			agendamento.setEmail(emailtxt);
			daoAgendamento.adiciona(agendamento);
			message = String.format("O agendametno para o dia %s às %d horas foi realizado com sucesso. %d pessoas foram agendadas, sendo elas:\n", datatxt, 
					hora,numPessoas);

			for (int i = 1; i <= numPessoas; i++) {
				nome = request.getParameter("nome"+i);
				cpf = request.getParameter("cpf"+i);
				tipoIngresso = request.getParameter("tipoIngresso"+i);

				message+="\n\t"+cpf+"  "+nome;
				
				pessoa = new Pessoa();
				pessoa.setCpf(cpf);
				pessoa.setNome(nome);
				
				daoPessoa.adiciona(pessoa);
				
				visitante = new Visitante();
				visitante.setCpf(cpf);
				visitante.setTipoIngresso(tipoIngresso);
				visitante.setIdAgendamento(daoAgendamento.recupera(codConfirmacao).getId());

				daoVisitante.adiciona(visitante);				
			}

			message+="\n\n"+codConfirmacao;
			
			EmailAgendamento email = new EmailAgendamento(emailtxt,subject,message);
			email.enviar();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "agendamento-concluido.jsp";
	}
	

	private String gerarHash(String senha) throws Exception {
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte hash[] = algorithm.digest(senha.getBytes("UTF-8"));

		StringBuilder texto = new StringBuilder();
		for (byte b : hash) {
			texto.append(String.format("%02X", 0xFF & b));
		}
		return texto.toString();
	}
	
}
