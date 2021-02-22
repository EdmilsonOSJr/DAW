package br.edu.ifsudestemg.barbacena.visitacao.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcuraVaga implements Logica{
	
	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
		
		String datatxt = request.getParameter("data");
		String horatxt = request.getParameter("hora");
		String museutxt = request.getParameter("codmuseu");
		String url = "agendamendo-pt2.jsp";
		
		System.out.println(datatxt);
		System.out.println(horatxt);
		System.out.println(museutxt);
		
		Calendar data = Calendar.getInstance();
		
		
		if(datatxt.equals(""))
			url = "agendamento-pt1.jsp";
		else {
			
			try {
				data.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(datatxt));
				
				if(data.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)
					url = "agendamento-pt1.jsp";
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println(data.getTime());
		
		
		return url;
	
	}
	
}
