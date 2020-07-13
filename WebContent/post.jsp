<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert </title>
</head>
<body>
	<form action="Postt" method="post">
	Content:<input type="text" name="content">
	<input type="hidden" name="email" value="<%=session.getAttribute("uname")%>">
	<input type="submit" value="dopost" name="post">
	</form>
	
</body>
</html>