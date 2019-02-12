package com.vish.security.security.demo.exceptions.handler;

import java.io.IOException;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.vish.security.security.demo.exceptions.FileExceptions;
import com.vish.security.security.demo.exceptions.ProductException;
import com.vish.security.security.demo.exceptions.model.ErrorDetails;
@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	Logger logger = LogManager.getLogger(CustomizedResponseEntityExceptionHandler.class);
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<Object> handleProductExceptions(Exception ex, WebRequest request) throws JsonParseException, JsonMappingException, IOException {
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(true));
		logger.info("Handled global exception successfully!!!!");
		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
				
	}
	@ExceptionHandler(FileExceptions.class)
	public ResponseEntity<Object> handleFileException(FileExceptions ex, WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(true));
		logger.info("Handled file exception!!!!");
		return new ResponseEntity(errorDetails,HttpStatus.NOT_ACCEPTABLE);
	}
	@ResponseStatus(code=HttpStatus.FORBIDDEN)
	@ExceptionHandler(AccessDeniedException.class)                   
	public ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException ex, WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(true));
		logger.info("Handled file exception!!!!");
		return new ResponseEntity(errorDetails,HttpStatus.FORBIDDEN);
	}
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

