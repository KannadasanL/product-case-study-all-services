package com.casestudy.product.service.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GenericExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFound(ResourceNotFoundException ex) {
		ProductErrorDetails errorDetails = new ProductErrorDetails(ex.getMessage());
		log.error("ResourceNotFoundException: {} ", errorDetails.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> genericException(Exception ex) {
		ProductErrorDetails errorDetails = new ProductErrorDetails(ex.getMessage());
		log.error("Exception: {} ", errorDetails.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
