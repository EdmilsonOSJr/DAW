<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:useBean id="dao" class="br.edu.ifsudestemg.barbacena.visitacao.dao.AgendamentoDAO"></jsp:useBean>
	<jsp:useBean id="daoMuseu" class="br.edu.ifsudestemg.barbacena.visitacao.dao.MuseuDAO"></jsp:useBean>
	
	<c:set var="nome" value="${daoMuseu.recupera(param.codmuseu).nome}"></c:set>
	<c:set var="vagas" value="${daoMuseu.recupera(param.codmuseu).numVisitantes - dao.numPessoas(param.data, param.hora, param.codmuseu)}"></c:set>
	
	<table border="1">
		<thead>
			<tr> 
				<th>data</th>
				<th>hora</th>
				<th>Museu</th>
				<th>número de vagas</th>
			</tr>
 		</thead>		
 		
 		<tr> 
			<td>${param.data}</td>			
			<td>${param.hora}</td>			
			<td>${nome}</td>
			<td>${vagas}</td>
		
 		</tr> 		
 		
	</table>
	
	<c:if test="${vagas > 0}">
		
		<form action="mvc" method="get">
			Número de pessoas: <input type="number"  min="1" max="${vagas}" value="1" name="numPessoas" required="required"/><br />
			Email: <input type="email" name="email" required="required"/><br />
			<input type="text" name="data" value="${param.data}" hidden="hidden"/>
			<input type="text" name="hora" value="${param.hora}" hidden="hidden"/>
			<input type="text" name="codMuseu" value="${param.codmuseu}" hidden="hidden" />
			<input type="text" name="vagas" value="${vagas}" hidden="hidden">
			<input type="text" name="logica" value="ValidaQtd" hidden="hidden"/>
			<input type="submit" value="Confirmar"/>
		</form>
	
	</c:if>
	
	
	
	<a href="agendamento-pt1.jsp">Cancelar</a>	
	
</body>
</html>