package com.vish.security.security.demo.exceptions;

import org.springframework.http.HttpStatus;

public class ProductException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private HttpStatus statusCode;
	
	public ProductException() {
		super();
	}
	public ProductException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	public ProductException(String errorMessage, HttpStatus statusCode) {
		super(errorMessage);
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	 
	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}



	
}
