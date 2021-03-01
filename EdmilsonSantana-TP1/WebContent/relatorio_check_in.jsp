<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="autentificacao_funcionario.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style_relatorio_check_in.css">
</head>
<body>


	<jsp:useBean id="dao"
		class="br.edu.ifsudestemg.barbacena.visitacao.dao.FuncionarioDAO"></jsp:useBean>
	<jsp:useBean id="daoMuseu"
		class="br.edu.ifsudestemg.barbacena.visitacao.dao.MuseuDAO"></jsp:useBean>

	<jsp:useBean id="daoP" class="br.edu.ifsudestemg.barbacena.visitacao.dao.PermissaoDAO"></jsp:useBean>
	

	<c:import url="cabecalho.jsp"></c:import>


	<div class="position-relative">
		<div class="position-absolute top-50 start-50 translate-middle-x shadow p-3 mb-5 bg-body rounded w-50 mt-5">
			<form action="mvc" method="get">
				<div class="mb-3">
				    <label class="form-label">Forneça a data para que a busca seja feita</label>
				    <input type="date" class="form-control"  name="data">
			  	</div>
			  	<div class="mb-3">
				  	<label for="exampleInputEmail1" class="form-label">Hora</label>
					 <select name="hora" class="form-control">
							  <option value="9">9</option>
							  <option value="10">10</option>
							  <option value="11">11</option>
							  <option value="12">12</option>
							  <option value="13">13</option>
							  <option value="14">14</option>
							  <option value="15">15</option>
							  <option value="16">16</option>
							  <option value="17">17</option>
							  <option value="18">18</option>
							  <option value="19">19</option>
							</select>
				</div>
				
					<c:choose>
					
						<c:when test="${sessionScope.permissao == daoP.recuperarPermissao('admin').id}">
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Museu</label>
								 <select name="codMuseu" class="form-control">
									<c:forEach var="museu" items="${daoMuseu.lista()}">
										  <option value="${museu.id}">${museu.nome}</option>			
									</c:forEach>
								</select>
							</div>
						</c:when>
						
						<c:otherwise>
							<input type="text" name="codMuseu" value="${dao.recuperarFuncionarioId(sessionScope.idFuncionario).idMuseu}" hidden="hidden" /> 
						</c:otherwise>
						
					</c:choose>
				
					<input type="text" name="logica" value="RelatorioCheckIn" hidden="hidden" /> 
					<button type="submit" class="btn btn-primary">Procurar</button><br/><br/>
			</form>
		</div>
	</div>

	<c:import url="rodape.jsp"></c:import>
</body>
</html>