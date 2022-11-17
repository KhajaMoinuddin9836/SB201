package com.masai.Exceptions;

import java.time.LocalDateTime;

public class MyError {

	private LocalDateTime lt;
	
	private String message;
	
	private String details;

	public MyError(LocalDateTime lt, String message, String details) {
		super();
		this.lt = lt;
		this.message = message;
		this.details = details;
	}

	public MyError() {
		
		
	}

	public LocalDateTime getLt() {
		return lt;
	}

	public void setLt(LocalDateTime lt) {
		this.lt = lt;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
