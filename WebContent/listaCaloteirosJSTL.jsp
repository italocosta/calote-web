<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="dao" class="br.triadworks.javaweb.dao.CaloteiroDAO" />

<html>
	<title>Lista de Caloteiros</title>
	<body>
		<table border="1">
			<c:forEach var="c" items="${dao.lista }" varStatus="id">
				<tr bgcolor="#${id.count % 2 == 0 ? 'ff0000':'ffffff' }">
				
					<td>${id.count }</td>
					
					<c:choose>
						<c:when test="${not empty c.email }">
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
							<td>${c.dataDivida.time }</td>
						</c:when>
						<c:otherwise>
							<td>Data da dívida não informada</td>
						</c:otherwise>
					</c:choose>
					
					
				</tr>
			</c:forEach>
		</table>
	</body>
</html>