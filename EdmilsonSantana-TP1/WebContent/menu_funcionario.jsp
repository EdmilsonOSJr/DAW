<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<%@ include file="autentificacao_funcionario.jsp" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style_menu_funcionario.css">
</head>
<body>

	
	<c:import url="cabecalho.jsp" />
	
	<h1 align="center">Menu Funcionário</h1>
	<hr>	
	
	<div id="formulario">
		<a href="agendamento-pt1.jsp" ><button>agendamento</button></a><br /><br />
		<a href="cancelamento-pt1.jsp" ><button>Cancelamento</button></a><br /><br />
		<a href="relatorio_por_dia.jsp"><button>Relatório pessoas por dia</button></a><br /><br />
		<a href="relatorio_check_in.jsp"><button>Relatório para check in</button></a><br /><br />
	</div>

</body>
</html>