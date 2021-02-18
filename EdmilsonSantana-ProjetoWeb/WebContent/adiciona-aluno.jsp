<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="autentificacao.jsp" %>

<!DOCTYPE html>
<html>
	<body>
		
		<c:import url="cabecalho.jsp"/>
		
		<form action="mvc" method="post">
			Nome:<input type = "text" name = "nome" /><br />
			Email:<input type = "text" name = "email" /><br />	
			Endereco:<input type = "text" name = "endereco" /><br />
			Data Nacimento:<input type = "text" name = "dataNascimento" /><br />
			<input type="text" hidden="hidden" name="logica" value="AdicionaAlunoLogic"/>
			<input type = "submit"  value = "Gravar" />
		</form>

		<c:import url="rodape.jsp"/>

	</body>
</html>