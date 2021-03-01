<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<%@ include file="autentificacao_admin.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

	<c:import url="cabecalho.jsp" />
	
	<jsp:useBean id="dao" class="br.edu.ifsudestemg.barbacena.visitacao.dao.MuseuDAO"></jsp:useBean>

	<div class="position-relative mb-5">
		
		<div class="position-absolute top-50 start-50 translate-middle-x shadow p-3 bg-body rounded w-50 mt-3">
			<form action="mvc" method="get">
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">Nome</label>
					<input type="text" class="form-control"  name="nome" required="required">
				</div>
	
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">Cpf</label>
					<input type="text" class="form-control"  name="cpf" required="required">
				</div>
				
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">Museu</label>
					<select name="codmuseu" class="form-control">
						<c:forEach var="museu" items="${dao.lista()}">
							  <option value="${museu.id}">${museu.nome}</option>			
						</c:forEach>
					</select>
				</div>
				
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">Definir login para funcionário</label>
					<input type="text" class="form-control"  name="login" required="required">
				</div>
				
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">Definir senha para funcionário</label>
					<input type="password" class="form-control"  name="senha" required="required">
				</div>
	
				<input type="text" name="logica" value="CadastroFuncionario" hidden="hidden"/>		
				<button type="submit" class="btn btn-primary mb-5">Cadastrar</button><br /><br />			
			</form>
		</div>
	</div>

	<c:import url="rodape.jsp"></c:import>
</body>
</html>