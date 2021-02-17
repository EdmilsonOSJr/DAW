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
	
	<c:import url="cabecalho.jsp"></c:import>
	
	<a href="adiciona-aluno.jsp">Adicionar Aluno</a>
	<br />	
	<a href="adiciona-professor.jsp">Adicionar Professor</a>
	<br />	
	<a href="lista-alunos-elegante.jsp">Listar Aluno</a>
	<br />	
	<a href="lista-professores-elegante.jsp">Listar Professor</a>
	<br />	
	
	
	<c:import url="rodape.jsp"></c:import>


</body>
</html>