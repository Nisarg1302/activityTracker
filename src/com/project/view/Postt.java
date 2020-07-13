package com.project.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.model.Post;
import com.project.servlet.PostDAOImpl;


@WebServlet("/Postt")
public class Postt extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Postt() {
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostDAOImpl po = new PostDAOImpl();
		
		String submitType = request.getParameter("post");
		
		
		 if(submitType.equals("dopost")) {
			 	Post p = new Post();
				
				p.setcontent(request.getParameter("content"));
				p.setEmail(request.getParameter("email"));
			  po.insertPost(p);
			  request.getRequestDispatcher("welcome.jsp").forward(request,response);
			  }else if(submitType.equals("Delete")) {
				  String pId = request.getParameter("postId");
				  po.removePost(pId);
				  request.getRequestDispatcher("welcome.jsp").forward(request,response);
			  
			  }else if(submitType.equals("Update")){ 
				  String pId = request.getParameter("postId");
				  String content = request.getParameter("content");
				  po.updatePost(pId,content);
				  request.getRequestDispatcher("welcome.jsp").forward(request,response);
			  }
	}

}
