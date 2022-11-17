package com.masai.Exceptions;

public class insufficientFundException extends RuntimeException{

	public insufficientFundException() {
		
	}
	
	public insufficientFundException(String mssg) {
		
		super(mssg);
	}
	
}
