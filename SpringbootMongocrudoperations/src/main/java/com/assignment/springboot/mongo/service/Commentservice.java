package com.assignment.springboot.mongo.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.assignment.springboot.mongo.model.Comment;

public interface Commentservice {

	public void createComment(List<Comment> emp);

	public Collection<Comment> getAllComments();

	public Optional<Comment> findCommentById(int id);

	public void deleteCommentById(int id);

	public Comment updateComment(Comment emp);

	public void deleteAllComments();
	
	public List<Comment> getCommentByLastName(String name);
	
	public List<Comment> getCommentByEmail(String email);

	 public void addComment(Comment com);
	 
	
}