package com.casestudy.product.price.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PriceErrorHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFound(ResourceNotFoundException ex) {
		PriceErrorDetails priceErrorDetails = new PriceErrorDetails(ex.getMessage());
		return new ResponseEntity<>(priceErrorDetails, HttpStatus.NOT_FOUND);
	}

	
	public ResponseEntity<?> generalException(Exception ex) {
		PriceErrorDetails priceErrorDetails = new PriceErrorDetails(ex.getMessage());
		return new ResponseEntity<>(priceErrorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
