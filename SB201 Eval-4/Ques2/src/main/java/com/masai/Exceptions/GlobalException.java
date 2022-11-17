package com.masai.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(insufficientFundException.class)
	public ResponseEntity<MyError> InsuficientFundException(insufficientFundException inf, WebRequest wr){
		
		MyError err = new MyError(LocalDateTime.now(), inf.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AccountException.class)
	public ResponseEntity<MyError> AcccountException(AccountException ac, WebRequest wr){
		
		MyError err = new MyError(LocalDateTime.now(), ac.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyError> AIException(MethodArgumentNotValidException ne, WebRequest wr){
		
		MyError err = new MyError(LocalDateTime.now(), ne.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> AIException(Exception e, WebRequest wr){
		
		MyError err = new MyError(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);
	}
	
}
