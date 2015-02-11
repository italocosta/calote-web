<%-- <jsp:useBean id="dao" class="br.triadworks.javaweb.dao.CaloteiroDAO" /> --%>
<%@ include file="/includes.jsp" %>

<html>
	<title>Lista de Caloteiros</title>
	<body>
		<c:import url="cabecalho.jsp"/>
		<form action="adiciona-caloteiro.jsp" method="post">
			<input type="submit" value="cadastrar">
		</form>
		<c:if test="${not empty lista}">
			<table border="1">
				<tr bgcolor="#888">
					<td>ID</td>
					<td>Nome</td>
					<td>Email</td>
					<td>Divida</td>
					<td>Data divida</td>
				</tr>
				<c:forEach var="c" items="${lista }" varStatus="id">
					<tr bgcolor="#${id.count % 2 == 0 ? 'ff0000':'ffffff' }">
					
						<td>${id.count }</td>
						
						<c:choose>
							<c:when test="${not empty c.nome }">
								<td>${c.nome }</td>
							</c:when>
							<c:otherwise>
								<td>Nome não informado</td>
							</c:otherwise>
						</c:choose>
						
						<c:choose>
							<c:when test="${not empty c.email }">
								<td><a href="mailto:${c.email }">${c.email }</a></td>
							</c:when>
							<c:otherwise>
								<td>Email não informado</td>
							</c:otherwise>
						</c:choose>
						
						<c:choose>
							<c:when test="${c.devendo > 0 }">
								<td>${c.devendo }</td>
							</c:when>
							<c:otherwise>
								<td>Não há divida</td>
							</c:otherwise>
						</c:choose>
						
						<c:choose>
							<c:when test="${not empty c.dataDivida }">
								<td>
									<fmt:formatDate value="${c.dataDivida.time }" pattern="dd/MM/yyyy"/>
								</td>
							</c:when>
							<c:otherwise>
								<td>Data da dívida não informada</td>
							</c:otherwise>
						</c:choose>
						
						
					</tr>
				</c:forEach>
				<tr>
					<img src="imagens/alt.png"/>
				</tr>
			</table>
		</c:if>
		<c:if test="${empty lista}">
			<i>Não há caloteiros cadastrado.</i><br>
		</c:if>
		<c:import url="rodape.jsp"/>
	</body>
</html>