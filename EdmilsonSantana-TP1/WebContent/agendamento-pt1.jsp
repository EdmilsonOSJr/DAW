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
	
	<c:import url="java.text.SimpleDateFormat" var="df"></c:import>
	<c:import url="java.util.Calendar" var="calendar"></c:import>
	
		
	<form action="mvc" method="get">
		Data: <input type="date"  min="2021-02-25"  name="data" /><br />
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
				
		Museu: <select name="codmuseu">
					<c:forEach var="museu" items="${dao.lista()}">
						  <option value="${museu.id}">${museu.nome}</option>			
					</c:forEach>
				</select><br />
				
		<input type="text" name="logica" value="ProcuraVaga" hidden="hidden"/><br />
		<input type="submit" value="Pesquisar Vagas"/><br />
	</form>
</body>
</html>