package br.edu.ifsudestemg.barbacena.visitacao.modelo;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailAgendamento {
	
	private Email email ;
	private String to;
	private String subject;
	private String message;

			
	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EmailAgendamento(String to, String subject, String message) {
		this.email = new SimpleEmail();
		this.to = to;
		this.message = message;
		this.subject = subject;
	}

	public void enviar() {
		
		try {
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthentication("controlevisitantesprefeiturabq@gmail.com", "Controle1234");
			email.setSSLOnConnect(true);
			email.setFrom("edmilsonosjr@gmail.com");
			email.setSubject(subject);
			email.setMsg(message);
			email.addTo(to);
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
