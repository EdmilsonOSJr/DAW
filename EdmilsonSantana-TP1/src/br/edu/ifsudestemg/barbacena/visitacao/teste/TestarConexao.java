package br.edu.ifsudestemg.barbacena.visitacao.teste;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.edu.ifsudestemg.barbacena.visitacao.dao.AgendamentoDAO;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Agendamento;

public class TestarConexao {

	public static void main(String[] args) throws ParseException, SQLException {

		
		Calendar data = Calendar.getInstance();
		
		String d = "21/02/2021";
		String h = "21:25:00";
		
		Date df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(d+" "+h);
		
		
		
		Agendamento g1 = new Agendamento();
				
		AgendamentoDAO daoa = new AgendamentoDAO();
		g1 = daoa.recupera("11774697661");
		
		System.out.println(g1.getCodConfirmacao());
		System.out.println(g1.getCodMuseu());
		System.out.println(g1.getCpf());
		System.out.println(g1.getEmail());
		System.out.println(g1.getDataHora().getTime());
		
//		Visitante v1 = new Visitante();
//		v1.setCpf("11774697661");
//		v1.setNome("Edmilson");
//		v1.setTipoIngresso("Adulto");
//		
//		VisitanteDAO daov = new VisitanteDAO();
//		
//		daov.adiciona(v1);
		
	}
}
