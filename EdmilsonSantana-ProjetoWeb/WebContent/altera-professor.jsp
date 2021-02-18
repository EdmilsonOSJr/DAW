<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:import url="cabecalho.jsp"></c:import>
	
	<form action="mvc" method="post">
		Id: <input type="text" name="id" readonly = "readonly" value="${param.id}"/><br />
		Nome: <input type="text" name="nome" value="${param.nome}"/><br />
		Email: <input type="text" name="email" value="${param.email}" /><br />
		Grau de Formacao: <input type="text" name="grauFormacao" value="${param.grauFormacao}" /><br />
		<input type="text" hidden="hidden" name="logica" value="AlteraProfessorLogic" />
		<input type="submit" value="Enviar" />
	</form>
	
	
	
	<c:import url="rodape.jsp"></c:import>
	
</body>
</html>