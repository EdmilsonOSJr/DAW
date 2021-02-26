package br.edu.ifsudestemg.barbacena.visitacao.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsudestemg.barbacena.visitacao.dao.FuncionarioDAO;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Funcionario;

public class CadastroFuncionario implements Logica{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
	
		String url = "funcionario_cadastrado.jsp";
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		Long codMuseu = Long.parseLong(request.getParameter("codMuseu"));
		
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setIdMuseu(codMuseu);
		
		FuncionarioDAO dao = new FuncionarioDAO();
		
		dao.adiciona(funcionario);		
		
		
		return url;
	
	}
	
	

}
