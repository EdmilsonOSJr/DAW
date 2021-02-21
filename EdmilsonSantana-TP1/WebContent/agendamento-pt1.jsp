<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="mvc" method="post">
		Data: <input type="text" name="data"/><br />
		Hora: <input type="text" name="hora"/><br />
		Museu <input type="text" name="codmuseu"/><br />
		<input type="text" name="logica" value="ProcuraVaga" hidden="hidden"/><br />
		<input type="submit" value="Pesquisar Vagas"/><br />
	</form>
</body>
</html>