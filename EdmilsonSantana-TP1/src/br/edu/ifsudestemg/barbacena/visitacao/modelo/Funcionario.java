package br.edu.ifsudestemg.barbacena.visitacao.modelo;

public class Funcionario {
	
	private Long id;	
	private String nome;
	private String cpf;
	private Long idMuseu;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Long getIdMuseu() {
		return idMuseu;
	}
	public void setIdMuseu(Long idMuseu) {
		this.idMuseu = idMuseu;
	}
	
	
	
}
