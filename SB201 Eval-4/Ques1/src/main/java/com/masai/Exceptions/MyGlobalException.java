package com.masai.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class MyGlobalException {

	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<MyError> employeeExceptionHandler(EmployeeException ee, WebRequest wr){
		
		MyError err = new MyError(LocalDateTime.now(), ee.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyError> validationExceptionHandler(MethodArgumentNotValidException me, WebRequest wr){
		
		MyError err = new MyError(LocalDateTime.now(), me.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> exceptionHandler(Exception e, WebRequest wr){
		
		MyError err = new MyError(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	
	
}
