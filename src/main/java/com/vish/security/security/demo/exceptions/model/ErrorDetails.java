package com.vish.security.security.demo.exceptions.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vish.security.security.demo.serilizer.ErrorDetailSerilizer;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
//@JsonSerialize(using = ErrorDetailSerilizer.class)
public class ErrorDetails {
	
	  private Date timestamp;
	  private String message;
	  private String details;

}
