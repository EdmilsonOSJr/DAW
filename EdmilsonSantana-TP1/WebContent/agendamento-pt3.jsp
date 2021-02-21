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
	
	<form action="mvc" method="get">
		<c:forEach  var="cont" begin="1"  end="${param.numPessoas}">
			
			Nome: <input type="text"  name="nome${cont}"/>
			cpf: <input type="text" name="cpf${cont}" />
			Tipo do Ingresso: <input type="text" name="tipoIngresso${cont}" /><br />
		</c:forEach>
		<input type="text" name="codMuseu" value="${param.codMuseu}" hidden="hidden"/>
		<input type="text" name="data" value="${param.data}" hidden="hidden"/>
		<input type="text" name="hora" value="${param.hora}" hidden="hidden"/>
		<input type="text" name="email" value="${param.email}" hidden="hidden"/>
		<input type="text" name="numPessoas" value="${param.numPessoas}" hidden="hidden"/>
		<input type="text" name="logica" value="ConcluiAgendamento" hidden="hidden"/>
		<input type="submit" value="Confirmar" /> 
	</form>
	
	<a href="agendamento-pt1.jsp">Cancelar</a>	
			
</body>
</html>