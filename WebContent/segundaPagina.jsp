<%String msg = "Isso é uma JSP"; %>
<html>
	<head>
		<title><% out.println(msg); %></title>
	</head>
	<body>
		<%=msg %>
	</body>
</html>