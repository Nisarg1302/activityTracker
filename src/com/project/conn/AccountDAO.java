package com.project.conn;

import com.project.model.User;

public interface AccountDAO {
	public int ClrAcDtl(String Email);
	public int ClrAcDtl1(String Email);
	public int DeltAcDtl(String Email);
	public User getFriends(String Tofind);
}
