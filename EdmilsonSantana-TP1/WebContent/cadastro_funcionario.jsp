<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="dao" class="br.edu.ifsudestemg.barbacena.visitacao.dao.MuseuDAO"></jsp:useBean>

	<form action="">
		Nome: <input type="text" name="nome" required="required" /><br />
		Cpf: <input type="text" name="cpf" required="required"/><br />	
		Museu: <select name="codmuseu">
					<c:forEach var="museu" items="${dao.lista()}">
						  <option value="${museu.id}">${museu.nome}</option>			
					</c:forEach>
				</select><br />	
		<input type="text" name="logica" value="CadastroFuncionario" hidden="hidden"/><br />		
		<input type="submit" name="Cadastrar"/><br />		
		
	</form>

</body>
</html>