package com.casestudy.product.service.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFound(ResourceNotFoundException ex) {
		ProductErrorDetails errorDetails = new ProductErrorDetails(ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> genericException(Exception ex) {
		ProductErrorDetails errorDetails = new ProductErrorDetails(ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
