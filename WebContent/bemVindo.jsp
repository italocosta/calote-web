<% String msg = "seja bem vindo ao meu JSP!"; %>
<html>
	<title><%=msg %></title>
	<body>
		Ol� <%=request.getParameter("nome") %>, <%=msg %>
	</body>
</html>