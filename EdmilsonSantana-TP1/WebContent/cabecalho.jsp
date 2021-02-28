<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
     
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	
	<div align="center" class="position-relative p-3 mb-2 bg-primary text-white" >
	
		<h2>Controle de Visitantes</h2>
		
		<c:if test="${sessionScope.status == true }">
			Olá ${sessionScope.nome} seja bem-vindo!<br>
			
			<a href="mvc?logica=EfetuarLogout" class="position-absolute bottom-0 end-0">
			<button type="button" class="btn btn-light border border-dark">logout</button> </a><br /><br />
		</c:if>
		
		<c:choose>
			<c:when test="${sessionScope.permissao == 0}">
				<a href="menu_adm.jsp" class="position-absolute bottom-0 start-0">
				<button type="button" class="btn btn-light border border-dark">Menu</button> </a>
			</c:when>
			<c:when test="${sessionScope.permissao == 1}">
				<a href="menu_funcionario.jsp" class="position-absolute bottom-0 start-0">
				<button type="button" class="btn btn-light border border-dark">Menu</button> </a>
			</c:when>
			<c:otherwise>
				<a href="menu.jsp" class="position-absolute bottom-0 start-0">
				<button type="button" class="btn btn-light border border-dark">Menu</button> </a>
			</c:otherwise>
		</c:choose>
		
	</div>
	
	
</body>
</html>