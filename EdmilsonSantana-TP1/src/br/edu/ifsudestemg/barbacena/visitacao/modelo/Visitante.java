package br.edu.ifsudestemg.barbacena.visitacao.modelo;

public class Visitante {
	
	private Long id;
	private String cpf;
	private String tipoIngresso;
	private Long idAgendamento;
	
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTipoIngresso() {
		return tipoIngresso;
	}
	public void setTipoIngresso(String tipoIngresso) {
		this.tipoIngresso = tipoIngresso;
	}
	public Long getIdAgendamento() {
		return idAgendamento;
	}
	public void setIdAgendamento(Long idAgendamento) {
		this.idAgendamento = idAgendamento;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
