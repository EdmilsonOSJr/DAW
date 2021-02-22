package br.edu.ifsudestemg.barbacena.visitacao.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;

import br.edu.ifsudestemg.barbacena.visitacao.dao.AgendamentoDAO;
import br.edu.ifsudestemg.barbacena.visitacao.dao.VisitanteDAO;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Agendamento;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Visitante;

public class ConcluiAgendamento implements Logica {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {

		Long numPessoas = Long.parseLong(request.getParameter("numPessoas"));
		String email = request.getParameter("email");
		String datatxt = request.getParameter("data");
		Long hora= Long.parseLong(request.getParameter("hora"));
		Long codMuseu = Long.parseLong(request.getParameter("codMuseu"));
		String nome;
		String cpf;
		String tipoIngresso;

		Date datad;

		try {
			datad = new SimpleDateFormat("yyyy-MM-dd").parse(datatxt);

			Calendar datac = Calendar.getInstance();
			datac.setTime(datad);

			Visitante visitante;
			Agendamento agendamento;

			AgendamentoDAO daoAgendamento = new AgendamentoDAO();
			VisitanteDAO daoVisitante = new VisitanteDAO();

			for (int i = 1; i <= numPessoas; i++) {
				nome = request.getParameter("nome"+i);
				cpf = request.getParameter("cpf"+i);
				tipoIngresso = request.getParameter("tipoIngresso"+i);

				visitante = new Visitante();
				visitante.setNome(nome);
				visitante.setCpf(cpf);
				visitante.setTipoIngresso(tipoIngresso);

				agendamento = new Agendamento();
				agendamento.setCodConfirmacao(gerarHash(cpf));
				agendamento.setCodMuseu(codMuseu);
				agendamento.setCpf(cpf);
				agendamento.setDataVisitacao(datac);
				agendamento.setHora(hora);
				agendamento.setEmail(email);

				daoVisitante.adiciona(visitante);
				daoAgendamento.adiciona(agendamento);
				

			}
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
