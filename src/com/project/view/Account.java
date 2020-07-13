package com.project.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.conn.AccountDAO;
import com.project.model.Post;
import com.project.servlet.AccountDAOImpl;

@WebServlet("/Account")
public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Account() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAOImpl ac = new AccountDAOImpl();
		
		String submitType = request.getParameter("account");
		
		
		 if(submitType.equals("ClearAccount")) {
			
			 String Email = request.getParameter("emailid");
			 ac.ClrAcDtl(Email);
			 ac.ClrAcDtl1(Email);
			  request.getRequestDispatcher("welcome.jsp").forward(request,response);
			  }
		 		else if(submitType.equals("DeleteAccount")) {
		 			
		 		String Email = request.getParameter("emailid");
		 		ac.ClrAcDtl(Email);
				 ac.ClrAcDtl1(Email);
				 ac.DeltAcDtl(Email);
				  request.getRequestDispatcher("register.jsp").forward(request,response);
		 		}else if(submitType.equals("Search")) {
			 			
		 			String Find = request.getParameter("Search");
		 			ac.getFriends(Find);
		 			request.getRequestDispatcher("register.jsp").forward(request,response);
	}
}
}