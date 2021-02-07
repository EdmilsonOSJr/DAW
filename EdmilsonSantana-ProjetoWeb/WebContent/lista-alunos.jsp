<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page
	import="java.util.*,
	br.edu.barbacena.ifsudestemg.daw.dao.*,
	br.edu.barbacena.ifsudestemg.daw.modelo.*"	
 %>
 
<html>
	<body>
		<h1>Tabela de Alunos</h1>
		<hr>
		<table border="1">
			<tr> 
				<th>Nome</th>
				<th>Email</th>
				<th>Endereço</th>
				<th>Data de Nacimento</th>
			</tr>	
			<%
				AlunoDAO dao = new AlunoDAO();
				List<Aluno> alunos = dao.listaAlunos();
				for(Aluno aluno : alunos){
			%>
				<tr> 
					<td><%= aluno.getNome()%></td>
					<td><%= aluno.getEmail()%></td>
					<td><%= aluno.getEndereco()%></td>
					<td><%= new SimpleDateFormat("dd/MM/yyyy").format(aluno.getDataNascimento().getTime())%></td>
				</tr>
				
			<%}//for%>
		</table>
	</body>
</html>