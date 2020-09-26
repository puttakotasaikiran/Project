package com.assignment.springboot.mongo.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.assignment.springboot.mongo.exception.CommentException;

@RestControllerAdvice
public class Advice {
	@ExceptionHandler(value = { CommentException.class })
	public ResponseEntity<String> handleException1(Exception ex) {
		//
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
