package br.edu.ifsudestemg.barbacena.visitacao.modelo;

public class Visitante {
	
	private String nome;
	private String cpf;
	private String tipoIngresso;
	private Long idAgendamento;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
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
	
	
	
}
