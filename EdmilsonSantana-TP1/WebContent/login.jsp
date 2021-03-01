<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body >
	
	<c:import url="cabecalho.jsp" />
	
	<div class="position-absolute top-50 start-50 translate-middle shadow p-3 mb-5 bg-body rounded w-25 p-3">
		<form action="mvc" method="post">
		  <div class="mb-3">
		    <label class="form-label">Login</label>
		    <input type="text" class="form-control"  name="login">
		  </div>
		  <div class="mb-3">
		    <label class="form-label">Password</label>
		    <input type="password" class="form-control" name="senha" id="exampleInputPassword1">
		  </div>
		  <input type="text" hidden="hidden" name="logica" value="EfetuarLogin"/>
		  <button type="submit" class="btn btn-primary">Entrar</button><br /><br />
		</form>
	</div>
	<c:import url="rodape.jsp"></c:import>
	
</body>
</html>