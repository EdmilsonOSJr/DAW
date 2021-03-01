<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Relatório Check In</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

	<jsp:useBean id="daoAgendamento" class="br.edu.ifsudestemg.barbacena.visitacao.dao.AgendamentoDAO" />
	<jsp:useBean id="daoVisitante" class="br.edu.ifsudestemg.barbacena.visitacao.dao.VisitanteDAO" />
	<jsp:useBean id="daoPessoa" class="br.edu.ifsudestemg.barbacena.visitacao.dao.PessoaDAO" />


	<c:import url="cabecalho.jsp"></c:import>
	
	<div align="center" class="mt-5">
		<table class="table">

			<tr align="center">
				<th>cpf</th>
				<th>nome</th>
				<th>tipo Ingresso</th>
				<th>presença</th>
				<th>Confirmar Presença</th>
			</tr>

			<c:forEach var="agendamento"
				items="${daoAgendamento.recuperaPorData(param.data, param.hora ,param.codMuseu)}">


				<c:forEach var="visitante"
					items="${daoVisitante.lista(agendamento.id)}">

					<tr align="center">
						<td>${visitante.cpf}</td>
						<td>${daoPessoa.recupera(visitante.cpf).nome}</td>
						<td>${visitante.tipoIngresso}</td>
						<td>
							<c:choose>
								<c:when test="${visitante.presenca == true}">
									Confirmado
								</c:when>
								
								<c:otherwise>
									Não Confirmado
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<a href="mvc?logica=AtualizaVisitante&id=${visitante.id}
							&hora=${param.hora}&data=${param.data}&codMuseu=${param.codMuseu}">
							<button type="submit" class="btn btn-primary">Confirmar</button></a>
						</td>
					</tr>

				</c:forEach>

			</c:forEach>


		</table><br /><br />
		
		<a href="relatorio_check_in.jsp"><button type="submit" class="btn btn-primary mb-4">Voltar</button></a>
	</div>

	<c:import url="rodape.jsp"></c:import>
</body>
</html>