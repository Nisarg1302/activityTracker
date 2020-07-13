package com.project.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.conn.AccountDAO;
import com.project.conn.ConnectionProvider;
import com.project.model.User;

public class AccountDAOImpl implements AccountDAO {

	static Connection con;
	static PreparedStatement ps;
	@Override
	public int ClrAcDtl(String Email) {
		int status=0;
		try {
			con=ConnectionProvider.getCon();
			ps=con.prepareStatement("delete from posts where Email=?");
			ps.setString(1, Email);
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return status;
	}

	@Override
	public int ClrAcDtl1(String Email) {
		int status=0;
		try {
			con=ConnectionProvider.getCon();
			ps=con.prepareStatement("delete from friends where RelatingUserEmail=? or RelatedUserEmail=?");
			ps.setString(1, Email);
			ps.setString(2, Email);
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return status;
	}

	@Override
	public int DeltAcDtl(String Email) {
		int status=0;
		try {
			con=ConnectionProvider.getCon();
			ps=con.prepareStatement("delete from user where Email=?");
			ps.setString(1, Email);
			ps.setString(2, Email);
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return status;
	}

	@Override
	public User getFriends(String Tofind) {
User u=new User();
		
		try {
			con=ConnectionProvider.getCon();
			ps=con.prepareStatement("select FirstName,LastName,Email from user where FirstName like '%?%' or LastName like '%?%' or Email like '%?%' ");
			ps.setString(1, Tofind);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				//sample/...........
				u.setFirstname(rs.getString(1));
				u.setLastname(rs.getString(2));
				u.setEmail(rs.getString(3));
			}
			
			con.close();
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		return u;
	
	}

}
