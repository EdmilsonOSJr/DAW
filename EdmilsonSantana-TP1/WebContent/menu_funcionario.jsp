<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<%@ include file="autentificacao_funcionario.jsp" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
<link rel="stylesheet" type="text/css" href="css/style_menu_funcionario.css">
</head>
<body>

	
	<c:import url="cabecalho.jsp" />
	
	<div>
		<ul class="nav flex-column">
			<li class="nav-item"><a class="nav-link active text-dark" aria-current="page" href="agendamento-pt1.jsp">Agendamento</a></li>
			<li class="nav-item"><a class="nav-link active text-dark" href="cancelamento-pt1.jsp">Cancelamento</a></li>
			<li class="nav-item"><a class="nav-link active text-dark" href="relatorio_por_dia.jsp">Relatório pessoas por dia</a></li>
			<li class="nav-item"><a class="nav-link active text-dark" href="relatorio_check_in.jsp">Relatório para check in</a></li>
			
		</ul>
	</div>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>