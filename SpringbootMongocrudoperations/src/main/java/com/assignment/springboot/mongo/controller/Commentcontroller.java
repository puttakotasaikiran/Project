package com.assignment.springboot.mongo.controller;

import java.util.Collection;

import java.util.List;
import java.util.Optional;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.springboot.mongo.model.Comment;
import com.assignment.springboot.mongo.service.Commentservice;

import io.swagger.annotations.Api;
@CrossOrigin
@Api(value = "Swagger2DemoRestController")
@RestController
@RequestMapping(value = "/api/mongo/com")
public class Commentcontroller {

	@Autowired
	Commentservice commentService;

	@PostMapping(value = "/create")
	public String create(@RequestBody List<Comment> com) {

		commentService.createComment(com);
		return "Comment records created.";
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<String> addEmp(@RequestBody Comment com) {

		commentService.addComment(com);
		return new ResponseEntity<String>("New Comment record created.",HttpStatus.OK);
	}
	

	@GetMapping(value = "/demo")
	public String getDemo() {

		return "DXC";
	}

	@GetMapping(value = "/getall")
	public Collection<Comment> getAll() {

		return commentService.getAllComments();
	}
	@GetMapping(value = "/getbyLastName/{name}")
	public List<Comment> getByName(@PathVariable(value="name")String name) {

		return commentService.getCommentByLastName(name);
	}
	@GetMapping(value = "/getbyEmail/{name}")
	public List<Comment> getByEmail(@PathVariable(value="name")String email) {

		return commentService.getCommentByEmail(email);
	}

	@GetMapping(value = "/getbyid/{comment-id}")
	public Optional<Comment> getById(@PathVariable(value = "comment-id") int id) {

		return commentService.findCommentById(id);
	}

	@PutMapping(value = "/update/{comment-id}")
	public String update(@PathVariable(value = "comment-id") int id, @RequestBody Comment e) {
		e.setId(id);
		commentService.updateComment(e);
		return "Comment record for comment-id= " + id + " updated.";
	}

	@DeleteMapping(value = "/delete/{comment-id}")
	public String delete(@PathVariable(value = "comment-id") int id) {
		commentService.deleteCommentById(id);
		return "Comment record for comment-id= " + id + " deleted.";
	}

	@DeleteMapping(value = "/deleteall")
	public String deleteAll() {
		commentService.deleteAllComments();
		return "All employee records deleted.";
	}
}