<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>${message}</h3>
<h3>${SuccessMessage}</h3>

	<form action="LoginRegister" method="post">
	Email:<input type="email" name="Email">
	Password:<input type="password" name="password">
	<input type="submit" value="login" name="user">
	<a href="register.jsp">Register</a>
	</form>
</body>
</html>