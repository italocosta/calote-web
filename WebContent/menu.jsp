<%@ include file="/includes.jsp" %>

<html>
	<head>
		<title>Menu sistema Caloteiro</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp"/>
		<p>Seja bem vindo, ${user.nome } ao nosso sistema de caloteiros.</p>
		<p>Menu</p>
		<p>
			<ol>
				<a href="<c:url value='/adiciona-caloteiro.jsp' />">
					Adicionar caloteiro
				</a>
			</ol>
			<ol>
				<a href="<c:url value='/sistema?acao=ListaCaloteiro' />">
					Lista caloteiro
				</a>
			</ol>
		<c:import url="rodape.jsp"/>
	</body>
</html>