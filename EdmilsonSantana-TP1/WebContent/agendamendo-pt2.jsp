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
	
	${param.data} ${param.hora} ${param.codmuseu}


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
		
		
				<c:choose>
					<c:when test="${param.codmuseu == 1}">
						<td>Museu Municipal de Barbacena</td>
						<c:set var="max" value="${5 - dao.agendamento(param.data, param.hora, param.codmuseu)}"></c:set>
						<td>${max}</td>
					</c:when>
					<c:otherwise>
						<td>Museu da Loucura</td>
						<c:set var="max" value="${10 - dao.agendamento(param.data, param.hora, param.codmuseu)}"></c:set>
						<td>${max}</td>		
					</c:otherwise>
				</c:choose>
 		</tr> 		
 		
	</table>
	
	<form action="mvc" method="get">
		Número de pessoas: <input type="number"  min="1" max="${max}" name="numPessoas" required="required"/><br />
		Email: <input type="email" name="email" required="required"/><br />
		<input type="text" name="data" value="${param.data}" hidden="hidden"/>
		<input type="text" name="hora" value="${param.hora}" hidden="hidden"/>
		<input type="text" name="codMuseu" value="${param.codmuseu}" hidden="hidden" />
		<input type="number" name="vagas" value="${max}" hidden="hidden">
		<input type="text" name="logica" value="ValidaQtd" hidden="hidden"/>
		<input type="submit" value="Confirmar"/>
	</form>
	
	<a href="agendamento-pt1.jsp">Cancelar</a>	
	
</body>
</html>