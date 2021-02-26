package br.edu.ifsudestemg.barbacena.visitacao.modelo;

public class Usuario {
	
	private String login;
	private String senha;
	private Long idFuncionario;
	private Long permissao;

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Long getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Long codMuseu) {
		this.idFuncionario = codMuseu;
	}
	public Long getPermissao() {
		return permissao;
	}
	public void setPermissao(Long permissao) {
		this.permissao = permissao;
	}
	
	
}
