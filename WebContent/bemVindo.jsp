<% String msg = "seja bem vindo ao meu JSP!"; %>
<html>
	<title><%=msg %></title>
	<body>
		Olá <%=request.getParameter("nome") %>, <%=msg %>
	</body>
</html>