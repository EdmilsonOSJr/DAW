<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		
		<h1 align="center">Tabela de conversão de Celsius para Fahrenheit</h1>
		<hr>
		
		<form action="temperatura.jsp" method="post">
			Temperatura inicial em Celsius: <input type="text"  name="temperaturaInicial"/><br />
			Temperatura final em Celsius: <input type="text"  name="temperaturaFInal"/><br />
			<input type="submit" value="Enviar"/>
		</form><br/>

		<% 
			try{
				double celsiusInicio = Double.parseDouble(request.getParameter("temperaturaInicial")); 
				double celsiusFim = Double.parseDouble(request.getParameter("temperaturaFInal"));
				
		%>

			<div align="center">
				<table border="1">
				
					<tr>
						<th>Celsius</th>
						<th>Fahrenheit</th>
					</tr>
					
					<%
						double fahrenheit = 0;
						
						for(;celsiusInicio<=celsiusFim;celsiusInicio+=10.0){
							fahrenheit = 9.0/5.0*celsiusInicio+32.0;
							
					
					%>
						
					<tr> 
						<td><%= celsiusInicio%></td>
						<td><%= fahrenheit%></td>
					</tr>
						
						
					<% }// for%>
					
				</table>
			</div>
		<% }catch(NullPointerException e){
			
		   }catch(NumberFormatException e){	%>
		
				<p>Dados Inválidos!!!		
		
		<%}//catch %>
		
	</body>
</html>