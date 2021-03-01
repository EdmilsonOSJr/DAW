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

	<jsp:useBean id="daoPermissao" class="br.edu.ifsudestemg.barbacena.visitacao.dao.PermissaoDAO"></jsp:useBean>
	
	
	<c:if test="${sessionScope.status != true}">
		<jsp:forward page="login.jsp" />		
	</c:if>
	
	
	<c:if test="${sessionScope.permissao != daoPermissao.recuperarPermissao('admin').id}">
		<jsp:forward page="login.jsp" />		
	</c:if>
	
</body>
</html>