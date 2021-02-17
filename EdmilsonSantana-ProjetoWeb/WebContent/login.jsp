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

	<c:import url="cabecalho.jsp"></c:import>
	
	<form action="mvc" method="post">
		Login: <input type="text" name="login"/><br />
		Password: <input type="password" name="senha" /><br />
		<input type="text" hidden="hidden" name="logica" value="EfetuarLogin"/>
		<input type="submit" value="Enviar" />
	
	</form>
	
	<c:import url="rodape.jsp"></c:import>

</body>
</html>