package br.edu.ifsudestemg.barbacena.visitacao.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsudestemg.barbacena.visitacao.dao.AgendamentoDAO;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Agendamento;

public class RelatorioPorDia implements Logica{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
	
		String idMuseu = request.getParameter("codMuseu");
		String dataTxt = request.getParameter("data");
		String url = "lista_relatorio_por_dia.jsp";
		
		Calendar dataAtual = Calendar.getInstance();
		Calendar dataFornecida = Calendar.getInstance();
		
		if(!dataTxt.isEmpty()) {
			try {
				int mes = dataAtual.get(Calendar.MONTH)+1;
				int ano = dataAtual.get(Calendar.YEAR);
				int dia = dataAtual.get(Calendar.DAY_OF_MONTH);
				
				dataFornecida.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(dataTxt));
				dataAtual.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(ano+"-"+mes+"-"+dia));
				
				AgendamentoDAO daoAgendamento = new AgendamentoDAO();
				List<Agendamento> agendamentos = new ArrayList<>();
				
				agendamentos = daoAgendamento.recuperaPorData(dataTxt,Long.parseLong(idMuseu));
				
				if(agendamentos.size()==0) 
					url = "relatorio_por_dia.jsp";
				
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
			url = "relatorio_por_dia.jsp";
		
		return url;
	
	}

}

