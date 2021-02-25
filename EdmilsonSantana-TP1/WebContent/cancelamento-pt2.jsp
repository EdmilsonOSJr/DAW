<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
	
	<jsp:useBean id="daoAgendamento"
		class="br.edu.ifsudestemg.barbacena.visitacao.dao.AgendamentoDAO" />
	<jsp:useBean id="daoVisitante"
		class="br.edu.ifsudestemg.barbacena.visitacao.dao.VisitanteDAO" />
	<jsp:useBean id="daoPessoa"
		class="br.edu.ifsudestemg.barbacena.visitacao.dao.PessoaDAO" />

	${daoAgendamento.recupera(param.codConfirmacao).id}


	<table border="1">
		<thead>
			<tr>
				<th>cpf</th>
				<th>nome</th>
				<th>Remover Visitante</th>
			</tr>
		</thead>

		<c:forEach var="visitante"
			items="${daoVisitante.lista(daoAgendamento.recupera(param.codConfirmacao).id)}">

			<tr>
				<td>${visitante.cpf}</td>
				<td>${daoPessoa.recupera(visitante.cpf).nome}</td>
				<td> <a href="mvc?cpf=${visitante.cpf}&codConfirmacao=${param.codConfirmacao}&logica=RemoverVisitante">Remover</a> </td>
			</tr>
			

		</c:forEach>



	</table>
	
	<a href="mvc?codConfirmacao=${param.codConfirmacao}&logica=RemoverAgendamento">Remover Todos</a>


</body>
</html>