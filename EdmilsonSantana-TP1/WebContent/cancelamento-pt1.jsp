<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancelamento</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	
	
	<c:import url="cabecalho.jsp"></c:import>

	<jsp:useBean id="daoPermissao" class="br.edu.ifsudestemg.barbacena.visitacao.dao.PermissaoDAO"></jsp:useBean>
	
	<div class="position-absolute top-50 start-50 translate-middle shadow p-3 mb-5 bg-body rounded w-50 p-3">
	
		<form action="mvc" method="post">
			 <div class="col-auto">
				<label  class="form-label">Código de confirmação</label>
		   		 <input type="text" name="codConfirmacao" required="required" class="form-control">	
			 </div>
			 <div class="mb-3">
			    <label for="exampleInputEmail1" class="form-label">Email</label>
			    <input type="email" class="form-control" name="email" required="required" aria-describedby="emailHelp">
			  </div>
			 
			 <c:choose>
				<c:when test="${sessionScope.permissao == daoPermissao.recuperarPermissao('funcionario').id}">
					<input type="text" hidden="hidden" name="idFuncionario" value="${sessionScope.idFuncionario}"/>
				</c:when>
			  
			 </c:choose> 
			<input type="text" hidden="hidden" name="logica" value="ValidaCancelamento"/>
			<button type="submit" class="btn btn-primary">Pesquisar</button><br /><br />
		</form>
	</div>
	
	<c:import url="rodape.jsp"></c:import>
</body>
</html>