package com.vish.security.security.demo.entity;

import org.springframework.http.ResponseEntity;

public class CustomResposeEntity {
	
	ResponseEntity<Object> responseEntity;
	String message;
	
	public ResponseEntity<Object> getResponseEntity() {
		return responseEntity;
	}
	public void setResponseEntity(ResponseEntity<Object> responseEntity) {
		this.responseEntity = responseEntity;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
