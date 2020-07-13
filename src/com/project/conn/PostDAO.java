package com.project.conn;

import com.project.model.Post;

public interface PostDAO {
	
	public int insertPost(Post p);
	public int removePost(String postId);
	public Post getPost(String postId);
	public int updatePost(String postId, String content);
}
