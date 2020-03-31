package com.springboot.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BadRequestExceptionHandler(String message) {
		super(message);
	}
	
}
