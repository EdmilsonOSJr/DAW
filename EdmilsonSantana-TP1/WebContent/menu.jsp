<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	
	<c:import url="cabecalho.jsp"></c:import>
	
	<div >
		<ul class="nav flex-column">
			<li class="nav-item"><a class="nav-link active text-dark" aria-current="page" href="agendamento-pt1.jsp">Agendamento</a></li>
			<li class="nav-item"><a class="nav-link active text-dark" href="cancelamento-pt1.jsp">Cancelamento</a></li>
			<c:if test="${sessionScope.status != true}">
				<li class="nav-item"><a class="nav-link active text-dark" href="login.jsp">Login</a></li>
			</c:if>
		</ul>
	</div>

	<c:import url="rodape.jsp"></c:import>

</body>
</html>