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
<body>
	
	
	<c:import url="cabecalho.jsp"></c:import>
	
	<div class="position-absolute top-50 start-50 translate-middle shadow p-3 mb-5 bg-body rounded w-50 p-3">
		<form action="mvc" method="get">
			 <div class="col-auto">
				<label  class="form-label">Código de confirmação</label>
		   		 <input type="text" name="codConfirmacao" required="required" class="form-control">	
			 </div>
			 <div class="mb-3">
			    <label for="exampleInputEmail1" class="form-label">Email</label>
			    <input type="email" class="form-control" name="email" required="required" aria-describedby="emailHelp">
			  </div>
			<input type="text" hidden="hidden" name="logica" value="ValidaCancelamento"/>
			<button type="submit" class="btn btn-primary">Entrar</button><br /><br />
		</form>
		<a href="menu.jsp"><button type="submit" class="btn btn-primary">Cancelar</button></a>
		
	</div>
	
</body>
</html>