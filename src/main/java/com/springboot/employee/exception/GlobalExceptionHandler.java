package com.springboot.employee.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		String error = "User not found.";
		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), error);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InternalServerError.class)
	public ResponseEntity<?> internalServerError(InternalServerError ex, WebRequest request) {
		String error = "Internal Server Error.";
		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), error);
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Unauthorized.class)
	public ResponseEntity<?> unauthorizedError(Unauthorized ex, WebRequest request) {
		String error = "You are not authorized user.";
		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.UNAUTHORIZED, ex.getLocalizedMessage(), error);
		return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(Forbidden.class)
	public ResponseEntity<?> forbiddenError(Forbidden ex, WebRequest request) {
		String error = "You are forbidden to go on this page.";
		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.FORBIDDEN, ex.getLocalizedMessage(), error);
		return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<?> badRequest(ConstraintViolationException ex, WebRequest request) {
		String error = "Required Parameter can not be null.";
		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> internalServerError(IllegalArgumentException ex, WebRequest request) {
		String error = "Internal Server Error";
		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	
}