<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	
	<jsp:useBean id="dao" class="br.edu.ifsudestemg.barbacena.visitacao.dao.AgendamentoDAO"></jsp:useBean>
	<jsp:useBean id="daoMuseu" class="br.edu.ifsudestemg.barbacena.visitacao.dao.MuseuDAO"></jsp:useBean>
	
	<c:set var="nome" value="${daoMuseu.recupera(param.codmuseu).nome}"></c:set>
	<c:set var="vagas" value="${daoMuseu.recupera(param.codmuseu).numVisitantes - dao.numPessoas(param.data, param.hora, param.codmuseu)}"></c:set>
	
	<c:import url="cabecalho.jsp"></c:import>
	
	<div class="position-relative mt-5">
	
		<div class="position-relative top-50 start-50 translate-middle-x">
			
			<table class="table">
				<thead>
					<tr> 
						<th scope="col">Data</th>
						<th scope="col">Hora</th>
						<th scope="col">Museu</th>
						<th scope="col">Número de vagas</th>
					</tr>
		 		</thead>		
		 		
		 		<tr > 
					<td scope="col">${param.data}</td>			
					<td scope="col">${param.hora}</td>			
					<td scope="col">${nome}</td>
					<td scope="col">${vagas}</td>
				
		 		</tr> 		
		 		
			</table>
			
		</div>
	
		<div class="position-relative top-50 start-50 translate-middle-x shadow-sm p-3 mb-5 bg-body rounded w-25 p-3">
			<c:if test="${vagas > 0}">
					<form action="mvc" method="get" >				
					  <div class="mb-3">
					    <label for="exampleInputEmail1" class="form-label">Número de Pessoas</label>
					    <input type="number" class="form-control"  min="1" max="${vagas}" value="1" name="numPessoas" required="required"/>
					  </div>
					  <div class="mb-3">
					    <label for="exampleInputEmail1" class="form-label">Email</label>
					    <input type="email" class="form-control" name="email" required="required" aria-describedby="emailHelp">
					  </div>
						<input type="text" name="data" value="${param.data}" hidden="hidden"/>
						<input type="text" name="hora" value="${param.hora}" hidden="hidden"/>
						<input type="text" name="codMuseu" value="${param.codmuseu}" hidden="hidden" />
						<input type="text" name="vagas" value="${vagas}" hidden="hidden">
						<input type="text" name="logica" value="ValidaQtd" hidden="hidden"/>
					  	<button type="submit" class="btn btn-primary">Entrar</button><br /><br />
					</form>
					
				</c:if>
					<a href="agendamento-pt1.jsp"><button type="submit" class="btn btn-primary">Voltar</button></a>	
		</div>
			
	</div>
	
		
		
	            
</body>
</html>