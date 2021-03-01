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

	<jsp:useBean id="daoPermissao" class="br.edu.ifsudestemg.barbacena.visitacao.dao.PermissaoDAO"></jsp:useBean>
	
	
	<div class="bg-dark text-white mb-3" >
	
		<h1 align="center">Sistema de Controle de Visitantes</h1><br>
		
		<ul class="nav nav-pills nav-fill">
			
			<c:choose>
				<c:when test="${sessionScope.permissao == daoPermissao.recuperarPermissao('admin').id}">
					<li class="nav-item">
						<a class="nav-dark active text-white text-decoration-none" href="menu_adm.jsp" >
							Menu
						</a>
					</li>
				</c:when>
				
				<c:when test="${sessionScope.permissao == daoPermissao.recuperarPermissao('funcionario').id}">
					<li class="nav-item">
						<a class="nav-dark active text-white text-decoration-none" href="menu_funcionario.jsp" >
							Menu
						</a>
					</li>
				</c:when>
				
				<c:otherwise>
					<li class="nav-item">
						<a class="nav-dark active text-white text-decoration-none" href="menu.jsp" >
							Menu
						</a>
					</li>
					
				</c:otherwise>
			</c:choose>
			
			<c:if test="${sessionScope.status == true }">
				<label>Olá ${sessionScope.nome} seja bem-vindo!</label> <br>
				<li class="nav-item">
						<a class="nav-dark active text-white text-decoration-none" href="mvc?logica=EfetuarLogout" >
							logout
						</a>
					</li>
			</c:if>
		
		</ul>
		
	</div>
	
	
</body>
</html>