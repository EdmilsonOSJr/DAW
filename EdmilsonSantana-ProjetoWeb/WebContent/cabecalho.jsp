<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<img src="imagens/cabecalho.png"/>
	<h2>Sistema de Gestão Acadêmica do Edmilson de Oliveira Santana Júnior</h2>
	<hr/>
	
	<c:if test="${sessionScope.status == true }">
		Olá ${sessionScope.nome} seja bem-vindo!<br>
		
		Clique <a href="mvc?logica=EfetuaLogout">aqui</a> para sair.<br />.<br />
	</c:if>
	
</body>
</html>