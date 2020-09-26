package com.assignment.springboot.mongo.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.springboot.mongo.dao.Commentdao;
import com.assignment.springboot.mongo.exception.CommentException;
import com.assignment.springboot.mongo.model.Comment;

@Service
public class Commentserviceimpl implements Commentservice {

	@Autowired
	Commentdao commentDao;

	@Override
	public void createComment(List<Comment> com) {
		commentDao.saveAll(com);
	}

	@Override
	public Collection<Comment> getAllComments() {
		return commentDao.findAll();
	}

	@Override
	public Optional<Comment> findCommentById(int id) {
		return commentDao.findById(id);
	}

	@Override
	public void deleteCommentById(int id) {
		commentDao.deleteById(id);
	}

	@Override
	public Comment updateComment(Comment com) {
		return commentDao.save(com);
	}

	@Override
	public void deleteAllComments() {
		commentDao.deleteAll();
	}

	@Override
	public List<Comment> getCommentByLastName(String name) {
		// TODO Auto-generated method stub

		return commentDao.findByLastName(name);
	}

	@Override
	public List<Comment> getCommentByEmail(String name) {
		// TODO Auto-generated method stub

		return commentDao.findByEmail(name);
	}

	@Override
	public void addComment(Comment com) {
		// TODO Auto-generated method stub
		if (commentDao.findById(com.getId()).isPresent()) {
			throw new CommentException("Id already exists");
		} else
			commentDao.save(com);

	}

}