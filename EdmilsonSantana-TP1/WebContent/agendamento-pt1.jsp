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
		Data: <input type="date" name="data" /><br />
		Hora: <select name="hora">
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
				</select><br />
		Escolha o Museu que deseja visitar: <br />
		<input type="radio" name="codmuseu" value="1" required="required"/>Museu Municipal de Barbacena<br />
		<input type="radio" name="codmuseu" value="2" required="required"/>Museu da Loucura<br />
		<input type="text" name="logica" value="ProcuraVaga" hidden="hidden"/><br />
		<input type="submit" value="Pesquisar Vagas"/><br />
	</form>
</body>
</html>