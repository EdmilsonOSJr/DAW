package br.edu.ifsudestemg.barbacena.visitacao.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcuraVaga implements Logica{
	
	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
		
		String dataTxt = request.getParameter("data");
		String url = "agendamendo-pt2.jsp";
				
		Calendar dataAtual = Calendar.getInstance();
		Calendar dataFornecida = Calendar.getInstance();
		
		try {
			int mes = dataAtual.get(Calendar.MONTH)+1;
			int ano = dataAtual.get(Calendar.YEAR);
			int dia = dataAtual.get(Calendar.DAY_OF_MONTH);
			
			if(!dataTxt.isEmpty()) {// Verifica se a data fornecida é nula.
				dataFornecida.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(dataTxt));
				dataAtual.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(ano+"-"+mes+"-"+dia));
				
				// Verifica se não é uma segunda-feira ou se a data é anteriror à data atual.
				if(dataFornecida.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY || dataFornecida.compareTo(dataAtual)<0)
					url = "agendamento-pt1.jsp";
			}
			else 
				url = "agendamento-pt1.jsp";
					
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		return url;
	
	}
	
}
