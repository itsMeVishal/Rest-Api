package com.vish.security.security.demo.exceptions;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
public class FileExceptions extends Exception implements Serializable {

	/**
	 * @author Vishal.Londhe
	 */
	private static final long serialVersionUID = 917547715312595347L;

	private String errorMessage;
	private HttpStatus statusCode;

	public FileExceptions(String string) {
		super(string);
	}
}
