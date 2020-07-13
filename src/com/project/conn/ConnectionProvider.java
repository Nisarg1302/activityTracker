package com.project.conn;

import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionProvider implements Provider {

	static Connection con=null;
	
	public static Connection getCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(connUrl,username,pwd);
		}
		catch(Exception e){
			System.out.print(e);
		}
		return con;
	}
}
