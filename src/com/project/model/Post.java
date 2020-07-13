package com.project.model;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;  
import java.util.Date; 

public class Post {
	private String content;
	private String Email;
	
	public String getpostID() {
		SecureRandom random = new SecureRandom();
		int num = random.nextInt(100000);
		String postID = String.format("%05d", num); 
		return postID;
	}
	public void setEmail(String Email) {
		this.Email=Email;
	}
	public String getEmail() {
		return Email;
	}
	
	public void setcontent(String content) {
		this.content=content;
	}
	public String getcontent() {
		return content;
	}
	
	public String getdate() {
		return java.time.LocalDate.now().toString();
	}

}
