<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<jsp:useBean id="dao" class="br.edu.barbacena.ifsudestemg.daw.dao.ProfessorDAO"></jsp:useBean>
	
	<table>
		<tr> 
			<th>Nome</th>
			<th>Email</th>
			<th>Grau de Formação</th>
			<th>Remover Aluno</th>
			<th>Alterar Aluno</th>
		</tr>
		
		<c:forEach var="professor" items="${dao.listaProfessores()}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff'}">
				<td>${professor.nome}</td>
				<td>
					<c:choose>
						<c:when test="${ not empty professor.email}">
							<a href="mail : ${professor.email}">${professor.email}</a>
						</c:when>
						<c:otherwise>
							Email não fornecido!!!
						</c:otherwise>
					</c:choose>					
				</td>
				<td>${professor.grauFormacao}</td>
				
				<td> 
					<a href="mvc?id=${professor.id}&logica=RemoveProfessorLogic">Remover</a>
				</td>
				<td> 
					<a href="altera-professor.jsp?id=${professor.id}&nome=${professor.nome}
					&email=${professor.email}&grauFormacao=${professor.grauFormacao}">Alterar</a>
				</td>
			</tr>
		</c:forEach>
	
	</table>
	
	<a href="adiciona-professor.jsp">Adicionar professor</a>
	
	<c:import url="rodape.jsp"/>	
</body>
</html>