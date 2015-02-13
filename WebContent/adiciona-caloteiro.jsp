<%@ include file="/includes.jsp" %>
<html>
	<head>
		<title>Adiciona caloteiro</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp"></c:import>
		<c:import url="menu_horizontal.html"/>
		<hr>
			Usuário logado : ${user.nome }
		<hr>
		<form action="sistema" method="post">
			<input type="hidden" value="AdicionaCaloteiro" name="acao">
			<div>
				<pog:formulario id="labelNome" campoName="nome" label="Nome: "/>
				<pog:formulario id="labelEmail" campoName="email" label="Email: "/>
				<pog:formulario id="labelDevendo" campoName="devendo" label="Devendo: "/>
				<pog:formulario id="labelData" campoName="data" label="Data: "/>
			</div>
			
			<input type="submit" value="Salvar">
		</form>
		<c:import url="rodape.jsp"></c:import>
	</body>
</html>