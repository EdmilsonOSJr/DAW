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
<body >
	
	<c:import url="cabecalho.jsp" />
	
	<div class="position-absolute top-50 start-50 translate-middle shadow p-3 mb-5 bg-body rounded w-25 p-3">
		<form action="mvc" method="post">
		  <div class="mb-3">
		    <label for="exampleInputEmail1" class="form-label">Login</label>
		    <input type="text" class="form-control"  name="login">
		  </div>
		  <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">Password</label>
		    <input type="password" class="form-control" name="senha" id="exampleInputPassword1">
		  </div>
		  <input type="text" hidden="hidden" name="logica" value="EfetuarLogin"/>
		  <button type="submit" class="btn btn-primary">Entrar</button><br /><br />
		</form>
		<a href="menu.jsp"><button type="submit" class="btn btn-primary">Voltar</button></a>
	</div>
	
	
</body>
</html>