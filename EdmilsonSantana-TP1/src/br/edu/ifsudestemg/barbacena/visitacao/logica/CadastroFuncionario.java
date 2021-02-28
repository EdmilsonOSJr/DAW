package br.edu.ifsudestemg.barbacena.visitacao.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsudestemg.barbacena.visitacao.dao.FuncionarioDAO;
import br.edu.ifsudestemg.barbacena.visitacao.dao.PermissaoDAO;
import br.edu.ifsudestemg.barbacena.visitacao.dao.UsuarioDAO;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Funcionario;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Usuario;

public class CadastroFuncionario implements Logica{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
	
		String url = "funcionario_cadastrado.jsp";
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String museutxt = request.getParameter("codmuseu");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		UsuarioDAO daoUsuario = new UsuarioDAO();
		PermissaoDAO daoPermissao = new PermissaoDAO();
		FuncionarioDAO daoFuncionario = new FuncionarioDAO();

		if(daoUsuario.validaCredencial(login, senha)==null && daoFuncionario.recuperarFuncionario(cpf)==null) {
			
			Funcionario funcionario = new Funcionario();
			funcionario.setNome(nome);
			funcionario.setCpf(cpf);
			funcionario.setIdMuseu(Long.parseLong(museutxt));
			
			
			FuncionarioDAO dao = new FuncionarioDAO();
			dao.adiciona(funcionario);		
			
			Usuario usuario = new Usuario();
			usuario.setLogin(login);
			usuario.setSenha(senha);
			usuario.setPermissao(daoPermissao.recuperarPermissao("funcionario").getId());
			usuario.setIdFuncionario(dao.recuperarFuncionario(cpf).getId());
			
			daoUsuario.adiciona(usuario);
			
		}
		else {
			url = "cadastro_funcionario.jsp";
		}
		
		
		
		return url;
	
	}
	
	

}
