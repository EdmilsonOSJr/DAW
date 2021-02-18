<%@page import="br.edu.barbacena.ifsudestemg.daw.modelo.Professor"%>
<%@page import="java.util.List"%>
<%@page import="br.edu.barbacena.ifsudestemg.daw.dao.ProfessorDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		
		<h1>Tabela de Professores</h1>
		<hr>
		
		<table border="1">
			<tr> 
				<th>Nome</th>
				<th>Email</th>
				<th>Grau de Formação </th>
			</tr>
			
			<%
				ProfessorDAO dao = new ProfessorDAO();
				List<Professor> professores = dao.listaProfessores();
				
				for(Professor professor : professores){
			%>
					<tr> 
						<td><%= professor.getNome()%></td>					
						<td><%= professor.getEmail()%> </td>					
						<td><%= professor.getGrauFormacao()%></td>					
					</tr>
					
			<%} //for %>
			
		</table>
		
		
	</body>
</html>