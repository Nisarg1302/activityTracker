package com.project.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.model.User;
import com.project.servlet.UserDAOImpl;

@WebServlet("/LoginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginRegister() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAOImpl ud = new UserDAOImpl();
		User u = new User();
		String Firstname = request.getParameter("Firstname");
		String Lastname = request.getParameter("Lastname");
		String Email = request.getParameter("Email");
		String Password = request.getParameter("password");
		String submitType = request.getParameter("user");

		u = ud.getUser(Email, Password);
		
		HttpSession session = request.getSession();
		
		  if(submitType.equals("login") && u!=null && u.getEmail()!=null) {
			  session.setAttribute("uname", u.getEmail());
		  request.setAttribute("Welcome",u.getFirstname());
		  request.getRequestDispatcher("welcome.jsp").forward(request,response);
		  
		  }else if(submitType.equals("register")) {
		  u.setFirstname(request.getParameter("Firstname"));
		  u.setLastname(request.getParameter("Lastname")); u.setPassword(Password);
		  u.setEmail(Email); ud.insertUser(u); request.setAttribute(
		  "SuccessMessage","Registration done,login to continue!!!");
		  request.getRequestDispatcher("login.jsp").forward(request,response);
		  
		  }else if(submitType.equals("Change")){ 
			  String Email1 = request.getParameter("Email");
			  String Password1 = request.getParameter("Password");
			  ud.changepassword(Email1,Password1);
			  System.out.print("alert('Password Change');");
			  request.getRequestDispatcher("login.jsp").forward(request,response);
		  }
		  else { request.setAttribute("message","User not found,Register now!!");
		  request.getRequestDispatcher("login.jsp").forward(request,response);
		  
		  }
		 
	}

}
