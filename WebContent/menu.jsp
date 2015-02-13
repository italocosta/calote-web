<%@ include file="/includes.jsp" %>

<html>
	<head>
		<title>Menu sistema Caloteiro</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp"/>
		<p>Seja bem vindo, ${user.nome } ao nosso sistema de caloteiros.</p>
		<c:import url="menu_horizontal.html"/>
		
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
		</p>
		
		<hr/>
		Variáveis EL:
		<p>
			1. param : ${param.nome }<br>
			2. requestScope : ${requestScope.nome }<br>
			3. sessionScope : ${sessionScope.nome }<br>
			4. Sem especificar : ${nome }<br>
		</p>
		<hr/>
			
		<c:import url="rodape.jsp"/>
	</body>
</html>