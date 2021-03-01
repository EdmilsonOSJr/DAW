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
	
	<div  class="position-absolute mt-5 start-50 translate-middle-x w-auto">
		<form action="mvc" method="get">
			<c:forEach  var="cont" begin="1"  end="${param.numPessoas}">
				<div class="row g-3 ">
					<div class="col-auto ">
					    <label for="exampleInputEmail1" class="form-label">Nome</label>
					    <input type="text" class="form-control"  name="nome${cont}" required="required"/>
				 	 </div>
					<div class="col-auto">
					    <label for="exampleInputEmail1" class="form-label">Cpf</label>
					    <input type="text" class="form-control"  name="cpf${cont}" required="required"/>
				 	 </div>
				 	 
					 <div class="col-auto">
					    <label class="form-label">Tipo do Ingresso</label>
					    <select name="tipoIngresso${cont}" class="form-control">
						  <option value="inteiro">Interiro</option>
						  <option value="meia">Meia Entrada</option>
						  <option value="isento">Isento</option>
						  <option value="morador">Morador Cadastrados</option>
						</select><br />
					</div>
				</div>
			</c:forEach>
			
			<input type="text" name="codMuseu" value="${param.codMuseu}" hidden="hidden"/>
			<input type="text" name="data" value="${param.data}" hidden="hidden"/>
			<input type="text" name="hora" value="${param.hora}" hidden="hidden"/>
			<input type="text" name="email" value="${param.email}" hidden="hidden"/>
			<input type="text" name="numPessoas" value="${param.numPessoas}" hidden="hidden"/>
			<input type="text" name="logica" value="ConcluiAgendamento" hidden="hidden"/><br />
			<button type="submit" class="btn btn-primary">Confirmar</button>
		</form><br />
		
		<div class="mb-5">
			<a href="agendamento-pt1.jsp" ><button type="submit" 
				class="btn btn-primary">Cancelar</button></a>	
		</div>
	</div>
	
	<c:import url="rodape.jsp"></c:import>
</body>
</html>