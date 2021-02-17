<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="autentificacao.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
	
	<c:import url="cabecalho.jsp" />
	Professor ${param.nome} adicionado com sucesso.
	<c:import url="rodape.jsp" />

</body>
</html>