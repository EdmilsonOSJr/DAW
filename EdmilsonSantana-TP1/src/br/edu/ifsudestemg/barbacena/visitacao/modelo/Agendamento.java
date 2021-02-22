package br.edu.ifsudestemg.barbacena.visitacao.modelo;

import java.util.Calendar;

public class Agendamento {
	
	private Long codMuseu;
	private String cpf;
	private String email;
	private String codConfirmacao;
	private Calendar dataVisitacao;
	private Long hora;
	
	
	public Long getCodMuseu() {
		return codMuseu;
	}
	public void setCodMuseu(Long nomeMuseu) {
		this.codMuseu = nomeMuseu;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpfVisitante) {
		this.cpf = cpfVisitante;
	}
	public String getCodConfirmacao() {
		return codConfirmacao;
	}
	public void setCodConfirmacao(String codConfirmacao) {
		this.codConfirmacao = codConfirmacao;
	}
	public Calendar getDataVisitacao() {
		return dataVisitacao;
	}
	public void setDataVisitacao(Calendar dataHora) {
		this.dataVisitacao = dataHora;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String emailVisitante) {
		this.email= emailVisitante;
	}
	public Long getHora() {
		return hora;
	}
	public void setHora(Long hora) {
		this.hora = hora;
	}
	
	
	
}
