package br.com.upabicas.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.upabicasreal.dao.UsuarioDAO;
import br.com.upareal.modelo.Usuario;

@SessionScoped
@ManagedBean
public class LoginBean {
	
	private Usuario usuario = new Usuario();
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public boolean isLogado() {
		return usuario.getLogin() != null;
	}
	
	public String efetuaLogin() {
		UsuarioDAO dao = new UsuarioDAO();
		
		boolean loginValido = dao.existe(this.usuario);
		
		
		if(loginValido) {
			return "medico?faces-redirect=true";
		} else 
			this.usuario = new Usuario();
			return "login?faces-redirect=true";
	}
	
	public String logout() {
		usuario = new Usuario();
		return "login?faces-redirect=true";
	}
}
