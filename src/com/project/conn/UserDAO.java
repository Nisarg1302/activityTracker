package com.project.conn;

import com.project.model.User;

public interface UserDAO {

	public int insertUser(User u);
	public User getUser(String Email,String Password);
	public int changepassword(String Email,String Password);
}
