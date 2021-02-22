<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="mvc" method="get">
		Código de Confirmação: <input type="text" name="codConfirmacao" required="required"/><br />
		Email: <input type="text" name="email" required="required"/><br />
		<input type="text" hidden="hidden" name="logica" value="ValidaCancelamento"/>
		<input type="submit" value="Pesquisar"/>
	
	</form>
	
</body>
</html>