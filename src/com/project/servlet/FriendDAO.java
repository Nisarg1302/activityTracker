package com.project.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.project.conn.ConnectionProvider;

public class FriendDAO {
	
	static Connection con;
	static PreparedStatement ps;

	
	public int removefriend(String frdemail,String memail){
		int status=0;
		try {
			con=ConnectionProvider.getCon();
			ps=con.prepareStatement("delete from friends where RelatingUserEmail=? and RelatedUserEmail=?");
			ps.setString(1, memail);
			ps.setString(2, frdemail);
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
}
