<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="autentificacao_funcionario.jsp" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style_relatorio_dia.css" />
</head>
<body>
						
		<jsp:useBean id="dao" class="br.edu.ifsudestemg.barbacena.visitacao.dao.FuncionarioDAO"></jsp:useBean>	
		
		<c:import url="cabecalho.jsp"></c:import>
		
		<div class="position-relative">
			<div class="position-absolute top-50 start-50 translate-middle-x shadow p-3 mb-5 bg-body rounded w-50 mt-5">
				
				<form action="mvc" method="get">
				
				<div class="mb-3">
					<label class="form-label">Forneça a data para que a busca seja feita</label>
					<input type="date" class="form-control"  name="data" required="required">
				</div>
					<input type="text" name="codMuseu" value="${dao.recuperarFuncionarioId(sessionScope.idFuncionario).idMuseu}" hidden="hidden"/>
					<input type="text" name="logica" value="RelatorioPorDia" hidden="hidden"/>
					<button type="submit" class="btn btn-primary">Procurar</button><br /><br />
				</form>
				
				<a href="menu_funcionario.jsp"><button type="submit" class="btn btn-primary">Cancelar</button></a>
			</div>			
			
		</div>
		
		
</body>
</html>