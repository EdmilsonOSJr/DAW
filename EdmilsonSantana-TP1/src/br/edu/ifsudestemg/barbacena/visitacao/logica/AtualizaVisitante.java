package br.edu.ifsudestemg.barbacena.visitacao.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsudestemg.barbacena.visitacao.dao.VisitanteDAO;
import br.edu.ifsudestemg.barbacena.visitacao.modelo.Visitante;

public class AtualizaVisitante implements Logica{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {

		String idMuseu = request.getParameter("codMuseu");
		String dataTxt = request.getParameter("data");
		String horaTxt = request.getParameter("hora");
		String id = request.getParameter("id");
		String url = "lista_relatorio_check_in.jsp?hora="+horaTxt+"&data="+dataTxt+"&codMuseu="+idMuseu;
		
		Visitante visitante = new Visitante();
		visitante.setId(Long.parseLong(id));
		
		VisitanteDAO dao = new VisitanteDAO();
		
		dao.atualiza(visitante);
		
		return url;
		
	}

}
