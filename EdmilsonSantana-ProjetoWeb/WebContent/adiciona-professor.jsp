<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		
		<c:import url="cabecalho.jsp"/>
		
		<form action="mvc" method="post"><br />
			Nome: <input type = "text" name = "nome"/><br />
			Email: <input type = "text" name = "email" /><br />
			Grau Formacao: <input  type = "text" name = "grauFormacao" /><br />
			<input type="text" hidden="hidden" name="logica" value="AdicionaProfessorLogic"/>
			<input type = "submit" value = "Gravar"/>		
		</form>
		
		<c:import url="rodape.jsp"/>
	</body>
	</html>