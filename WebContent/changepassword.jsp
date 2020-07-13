<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="com.project.conn.ConnectionProvider"%>
<%@page import="java.sql.ResultSet" %>
<% 
String Email = request.getParameter("Email");
Connection con = ConnectionProvider.getCon();
PreparedStatement ps;
ps=con.prepareStatement("select password from user where Email=?");
ps.setString(1, Email);
ResultSet rs=ps.executeQuery();
String password="";
while(rs.next())
	password=rs.getString(1);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body>
	<form action="LoginRegister" method="post">
	
	<input type="text" name="Email" value="<%=Email%>" readonly>
	Type new password:<input type="text" name="Password" value="<%=password%>">
	<input type="submit" value="Change" name="user">
</body>
</html>