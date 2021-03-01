<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancelamento</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

	<c:import url="cabecalho.jsp" />
	
	<jsp:useBean id="daoAgendamento" class="br.edu.ifsudestemg.barbacena.visitacao.dao.AgendamentoDAO" />
	<jsp:useBean id="daoVisitante" class="br.edu.ifsudestemg.barbacena.visitacao.dao.VisitanteDAO" />
	<jsp:useBean id="daoPessoa" class="br.edu.ifsudestemg.barbacena.visitacao.dao.PessoaDAO" />


	<div align="center" class="position-relative top-50 start-50 translate-middle-x">
		
		<table class="table">
			<thead>
				<tr align="center">
					<th scope="col">cpf</th>
					<th scope="col">nome</th>
					<th scope="col">Remover Visitante</th>
				</tr>
			</thead>
	
			<c:forEach var="visitante"
				items="${daoVisitante.lista(daoAgendamento.recupera(param.codConfirmacao).id)}">
	
				<tr align="center">
					<td scope="col">${visitante.cpf}</td>
					<td scope="col">${daoPessoa.recupera(visitante.cpf).nome}</td>
					<td scope="col"><a href="mvc?cpf=${visitante.cpf}&codConfirmacao=${param.codConfirmacao}&logica=RemoverVisitante"><button type="submit" class="btn btn-primary">Remover</button></a> </td>
				</tr>
			</c:forEach>
	
		</table><br /><br />
		
		<div class="position-relative start-50 translate-middle">	
			<a href="mvc?codConfirmacao=${param.codConfirmacao}&logica=RemoverAgendamento"><button type="submit" class="btn btn-primary">Remover Todos</button></a>
			<a href="cancelamento-pt1.jsp"><button type="submit" class="btn btn-primary">Cancelar</button></a>
		</div>
	</div>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>