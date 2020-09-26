package com.assignment.springboot.mongo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.assignment.springboot.mongo.model.Comment;

@Repository
public interface Commentdao extends MongoRepository<Comment, Integer> {

	List<Comment> findByLastName(String lastname);
	List<Comment> findByEmail(String email);



}