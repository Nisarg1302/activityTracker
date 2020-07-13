package com.project.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.conn.ConnectionProvider;
import com.project.conn.PostDAO;
import com.project.model.Post;

public class PostDAOImpl implements PostDAO{

	static Connection con;
	static PreparedStatement ps;
	@Override
	public int insertPost(Post p) {
		int status=0;
		try {
			con=ConnectionProvider.getCon();
			ps=con.prepareStatement("insert into posts values(?,?,?,?)");
			ps.setString(1, p.getpostID());
			ps.setString(2, p.getEmail());
			ps.setString(3, p.getcontent());
			ps.setString(4, p.getdate());
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
	
	public int removePost(String postId){
		int status=0;
		try {
			con=ConnectionProvider.getCon();
			ps=con.prepareStatement("delete from posts where postID=?");
			ps.setString(1, postId);
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
	@Override
	public Post getPost(String postId) {
		Post p=new Post();
		
		try {
			con=ConnectionProvider.getCon();
			ps=con.prepareStatement("select * from posts where email=?");
			ps.setString(1, postId);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				p.setEmail(rs.getString(2));
				p.setcontent(rs.getString(3));
			}
			
			con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return p;
	}

	@Override
	public int updatePost(String postId, String content) {
		// TODO Auto-generated method stub
		int status=0;
		try {
			con=ConnectionProvider.getCon();
			ps=con.prepareStatement("update posts set content=? where postID=?");
			ps.setString(1, content);
			ps.setString(2, postId);
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
	
	

}
