<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<c:import url="cabecalho.jsp" />
	
	<div id="botoes">
		<a href="agendamento-pt1.jsp" ><button>agendamento</button></a><br /><br />
		
		<a href="cancelamento-pt1.jsp" ><button>Cancelamento</button></a><br /><br />
		
		
		<c:if test="${sessionScope.status != true}">
			<a href="login.jsp"><button>Login</button></a>
		</c:if>
	</div>
	
	
</body>
</html>