<%@ include file="/includes.jsp" %>
<html>
	<head>
		<title>Acessar sistema caloteiro</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp"></c:import>
			<form action="sistema?acao=AutenticaUsuario" method="post">
				<input type="hidden" value="Parametro" name="nome"/>
				Login : <input type="text" name="login"/><br>
				Senha : <input type="password" name="senha"/><br>
				<input type="submit" value="Entrar"/>
			</form>
			<p>${msg }</p>
		<c:import url="rodape.jsp"></c:import>
	</body>
</html>