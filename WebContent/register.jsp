<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginRegister" method="post">
	Firstname:<input type="text" name="Firstname">
	Lastname:<input type="text" name="Lastname">
	Email:<input type="email" name="Email">
	Password:<input type="password" name="password">
	<input type="submit" value="register" name="user">
	<a href="register.jsp">Register</a>
	</form>
</body>
</html>