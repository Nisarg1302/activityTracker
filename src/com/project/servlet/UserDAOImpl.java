package com.project.servlet;

import java.sql.*;

import com.project.conn.ConnectionProvider;
import com.project.conn.UserDAO;
import com.project.model.User;


public class UserDAOImpl implements UserDAO {

	static Connection con;
	static PreparedStatement ps;
	@Override
	public int insertUser(User u) {
		int status=0;
		try {
			con=ConnectionProvider.getCon();
			ps=con.prepareStatement("insert into user value(?,?,?,?)");
			ps.setString(1, u.getFirstname());
			ps.setString(2, u.getLastname());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return status;
	}

	@Override
	public User getUser(String Email, String Password) {
		User u=new User();
		
		try {
			con=ConnectionProvider.getCon();
			ps=con.prepareStatement("select * from user where Email=? and Password=?");
			ps.setString(1, Email);
			ps.setString(2, Password);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				u.setFirstname(rs.getString(1));
				u.setLastname(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
			}
			
			con.close();
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		return u;
	}

	@Override
	public int changepassword(String Email1, String Password1) {
		int status=0;
		try {
			con=ConnectionProvider.getCon();
			ps=con.prepareStatement("update user set Password=? where Email=?");
			ps.setString(1, Password1);
			ps.setString(2, Email1);
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return status;
	}

	}

