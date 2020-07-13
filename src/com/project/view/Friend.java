package com.project.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.servlet.FriendDAO;


@WebServlet("/Friend")
public class Friend extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Friend() {
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FriendDAO fr = new FriendDAO();
		
		String submitType = request.getParameter("Friends");
		
		if(submitType.equals("Remove")) 
		{
			  String myemail = request.getParameter("self");
			  String friendsemail = request.getParameter("Friend");
			  fr.removefriend(friendsemail,myemail);
			  request.getRequestDispatcher("welcome.jsp").forward(request,response);
		}

	}
}