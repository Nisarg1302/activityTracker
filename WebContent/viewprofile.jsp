<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="com.project.conn.ConnectionProvider"%>
<%@page import="java.sql.ResultSet" %>
<% if(session.getAttribute("uname") == null || session.getAttribute("uname").equals("")){
	response.sendRedirect("login.jsp");}%>

<% 
String Email = request.getParameter("Email");
Connection con = ConnectionProvider.getCon();
PreparedStatement ps;
ps=con.prepareStatement("select * from posts where Email=?");
ps.setString(1, Email);
ResultSet rs=ps.executeQuery();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<h2>Post</h2>
<body>
<h1>UserName: <%= Email%></h1>
<table border="1">
        <tr>
            <td>Content</td>
            <td>date</td>
        </tr>
	<%
	while(rs.next()) {
%>
	<tr>
		<td><%=rs.getString(3) %></td>
		<td><%=rs.getString(4) %></td>
	</tr>
	<%
	}
%>

</body>
</html>