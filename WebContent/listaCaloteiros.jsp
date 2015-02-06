<%@ page import="br.triadworks.javaweb.dao.CaloteiroDAO" %>
<%@ page import="br.triadworks.javaweb.modelo.Caloteiro" %>
<%@ page import="java.util.List" %>
<html>
	<title>Lista de Caloteiros</title>
	<body>
		<%
			CaloteiroDAO dao = new CaloteiroDAO();
			List<Caloteiro> lista = dao.getLista();
			for(Caloteiro c : lista){
				%>
					<li> <%=c.getNome() %> - <%=c.getEmail() %> - <%=c.getDevendo() %></li>
				
				<%
			}
		%>
	</body>
</html>