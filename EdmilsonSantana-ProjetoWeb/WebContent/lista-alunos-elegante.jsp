<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<jsp:useBean id="dao" class="br.edu.barbacena.ifsudestemg.daw.dao.AlunoDAO"/>
	
	<table border="1">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Endereço</th>
				<th>Data de Nacimento</th>
				<th>Remover Aluno</th>
				<th>Alterar Aluno</th>
			</tr>
		</thead>
		<c:forEach var="aluno" items="${dao.listaAlunos()}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff'}">
				<td>${aluno.nome} </td>
				<td>
					<c:choose>
						<c:when test="${ not empty aluno.email}">
							<a href="mailto : ${aluno.email}">${aluno.email}</a>
						</c:when>
						<c:otherwise>
							Email não informado!!							
						</c:otherwise>
					</c:choose>
				</td>
				<td>${aluno.endereco} </td>
				<td>
					<fmt:formatDate value="${aluno.dataNascimento.time}" pattern="dd/MM/yyyy"/>
				</td>
				<td>
					<a href="mvc?id=${aluno.id}&logica=RemoveAlunoLogic">Remover</a>
				</td>
				<td>
					<a href="altera-aluno.jsp?id=${aluno.id}&nome=${aluno.nome}&email=${aluno.email}&endereco=${aluno.endereco}
					&dataNascimento=<fmt:formatDate value="${aluno.dataNascimento.time}" pattern="dd/MM/yyyy"/>&logica=AlteraAlunoLogic">Alterar</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<br/>
	<a href="adiciona-aluno.jsp">Adicionar novo aluno</a>
		
	<c:import url="rodape.jsp"/>
	
</body>
</html>