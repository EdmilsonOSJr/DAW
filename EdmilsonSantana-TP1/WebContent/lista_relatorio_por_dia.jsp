<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Relatório por Dia</title>
<link rel="stylesheet" type="text/css" href="css/style_lista_relatorio_dia.css">
</head>
<body>
		
		<jsp:useBean id="daoAgendamento" class="br.edu.ifsudestemg.barbacena.visitacao.dao.AgendamentoDAO" />
		<jsp:useBean id="daoVisitante" class="br.edu.ifsudestemg.barbacena.visitacao.dao.VisitanteDAO" />
		<jsp:useBean id="daoPessoa" class="br.edu.ifsudestemg.barbacena.visitacao.dao.PessoaDAO" />
		
		
		<c:import url="cabecalho.jsp"></c:import>
		
		
		
		
			<div align="center" class="position-relative top-50 start-50 translate-middle-x">
				<table class="table">
					<tr align="center"><th colspan="5">Visitantes por dia </th></tr>
					<tr align="center"> 
						<th>Cpf</th>
						<th>Nome</th>
						<th>Tipo Ingresso</th>
					</tr>	
					
					<c:forEach var="agendamento" items="${daoAgendamento.recuperaPorData(param.data, param.codMuseu)}">
						
						
						<c:forEach var="visitante" items="${daoVisitante.listaPresenca(agendamento.id)}" >
						
							<tr align="center"> 
								<td>${visitante.cpf}</td>
								<td>${daoPessoa.recupera(visitante.cpf).nome}</td>
								<td>${visitante.tipoIngresso}</td>
							</tr>
						
						</c:forEach>
					</c:forEach>				
				</table><br /><br />
				<a href="relatorio_por_dia.jsp"><button type="submit" class="btn btn-primary">Voltar</button></a>
			</div>
		<c:import url="rodape.jsp"></c:import>
</body>
</html>