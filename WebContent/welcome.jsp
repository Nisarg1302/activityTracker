<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="com.project.conn.ConnectionProvider"%>
<%@page import="java.sql.ResultSet" %>
<% 
if(session.getAttribute("uname") == null || session.getAttribute("uname").equals("")){
	response.sendRedirect("login.jsp");
}else{
	String email = session.getAttribute("uname").toString();
	Connection con = ConnectionProvider.getCon();
	PreparedStatement ps;
	ps=con.prepareStatement("select * from posts where email=?");
	ps.setString(1, email);
	ResultSet rs=ps.executeQuery();
	%>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Post Detail</title>
</head>
<body>
<header>
<h4 style="float:left">
<form action="logout" method="post">
<input type="hidden" name="emailid" value="<%=email %>"/>
    <input type="submit" name="logout" value="logout" />
</form> 
<br>
<form action="Account" method="post" >
	<input type="hidden" name="emailid" value="<%=email %>"/>
    <input type="submit"  name="account" value="ClearAccountDetail"  />
     <input type="submit"  name="account" value="DeleteAccount"  />
     <a href="changepassword.jsp?Email=<%=email %>">Change-Password</a>
      <a href="welcome.jsp?Email=<%=email %>">Add new Friends</a>
</form></h4>
<br>
<br>
<div style="float:right">
<form action="Account" method="post">
	Search:<input type="text" name="search">
	 <a href="Friends.jsp?find=<%=email %>">Search</a>
</div>

</header>
<br>
<br>
<br>
<br>
<h1 >UserName: <%= email%></h1>

<table border="1">
<h2>Posts</h2>
<h3><a href="post.jsp">Add Post</a></h3>
        <tr>
        	<td>Id</td>
        	<td>Email</td>
            <td>Content</td>
            <td>date</td>
            <td>Delete</td>
            <td>Update</td>
        </tr>
	<%
	while(rs.next()) {
%>
	<tr>
		<td><%=rs.getString(1) %></td>
		<td><%=rs.getString(2) %></td>
		<td><%=rs.getString(3) %></td>
		<td><%=rs.getString(4) %></td>
		<td><form action='Postt' method="post">
		<input type='hidden' name='postId' id='postId' value='<%=rs.getString(1) %>' />
		<input type='submit' name='post' value='Delete' />
		</form>
		</td>
		<td><a href="updatePost.jsp?postId=<%=rs.getString(1) %>">Update</a></td>
	</tr>

<%		
	}
} %>
</table>

<% 
	String email = session.getAttribute("uname").toString();
	Connection con = ConnectionProvider.getCon();
	PreparedStatement ps;
	ps=con.prepareStatement("select * from friends where RelatingUserEmail=? and status=1 or RelatedUserEmail=? and status=1;");
	ps.setString(1, email);
	ps.setString(2, email);
	ResultSet rs=ps.executeQuery();
	%>
	
	<br>
	<br>
	
<table border="2">
<h2>Friends</h2>
        <tr>
        	<td>Friends</td>
            <td>View-Profile</td>
            <td>Remove</td>
            
        </tr>
	<%
	String Mymail="";
	String Friendmail="";
	String checkmail="";
	while(rs.next()) {
		checkmail=rs.getString(1);
		if(!email.equals(checkmail)){
			Friendmail=rs.getString(1);
			Mymail=rs.getString(2);
			
		}else{
			Mymail=rs.getString(1);
			Friendmail=rs.getString(2);
		}
%>
	<tr>
		<td><%=Friendmail %></td>
		<td><a href="viewprofile.jsp?Email=<%=Friendmail %>">View</a>
		</form>
		</td>
		<td><form action='Friend' method="post">
		<input type='hidden' name='self' id='self' value='<%=Mymail %>' />
		<input type='hidden' name='Friend' id='Friend' value='<%=Friendmail %>' />
		<input type='submit' name='Friends' value='Remove' />
		</form>
		</td>
	</tr>

<%		
	}
	%>
</table>
	
</body>
</html>