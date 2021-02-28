<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style_menu_adm.css">
</head>
<body>

	<c:import url="cabecalho.jsp" />
	
	<div id="formulario" title="Menu do desenvolvedor">
		<a href="agendamento-pt1.jsp" ><button>Agendamento</button></a><br /><br />
		<a href="cancelamento-pt1.jsp" ><button>Cancelamento</button></a><br /><br />
		<a href="cadastro_funcionario.jsp"><button>Cadastrar Funcionário</button></a><br /><br />
	</div>
	
	
	
</body>
</html>