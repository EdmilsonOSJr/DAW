package br.edu.ifsudestemg.barbacena.visitacao.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcuraVaga implements Logica{
	
	private int horarioInicial = 9;
	private int horarioFinal = 19;
	
	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
		
		String datatxt = request.getParameter("data");
		String horatxt = request.getParameter("hora");
		String url = "agendamendo-pt2.jsp";
		
		Calendar datahora = Calendar.getInstance();
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(datatxt+" "+horatxt);
			datahora.setTime(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(datahora.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY || datahora.get(Calendar.HOUR_OF_DAY)<horarioInicial || datahora.get(Calendar.HOUR_OF_DAY)>=horarioFinal)
			url = "agendamento-pt1.jsp";
		
		return url;
	
	}
	
}
