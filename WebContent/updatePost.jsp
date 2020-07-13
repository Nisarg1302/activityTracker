<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="com.project.conn.ConnectionProvider"%>
<%@page import="java.sql.ResultSet" %>
<% if(session.getAttribute("uname") == null || session.getAttribute("uname").equals("")){
	response.sendRedirect("login.jsp");}
	%>
<% 
String postId = request.getParameter("postId");
Connection con = ConnectionProvider.getCon();
PreparedStatement ps;
ps=con.prepareStatement("select content from posts where postID=?");
ps.setString(1, postId);
ResultSet rs=ps.executeQuery();
String content="";
while(rs.next()){
	content=rs.getString(1);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Post</title>
</head>
<body>
	<form action="Postt" method="post">
	<input type="hidden" name="postId" value="<%=postId%>">
	Content:<input type="text" name="content" value="<%=content%>">
	<input type="submit" value="Update" name="post">
	</form>
</body>
</html>