package com.masai.Exceptions;

import java.time.LocalDateTime;

public class MyError {

	private LocalDateTime dt;
	
	private String message;
	
	private String Description;

	public MyError() {
		// TODO Auto-generated constructor stub
	}
	
	public MyError(LocalDateTime dt, String message, String description) {
		super();
		this.dt = dt;
		this.message = message;
		Description = description;
	}

	public LocalDateTime getDt() {
		return dt;
	}

	public void setDt(LocalDateTime dt) {
		this.dt = dt;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	
}
