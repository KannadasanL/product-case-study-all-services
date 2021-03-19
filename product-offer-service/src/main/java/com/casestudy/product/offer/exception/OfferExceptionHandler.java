package com.casestudy.product.offer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OfferExceptionHandler {
	
	@ExceptionHandler(OfferNotFound.class)
	public ResponseEntity<?> offerNotFound(OfferNotFound ex) {
		OfferErrorDetails errorDetails = new OfferErrorDetails(ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> otherExceptions(Exception ex) {
		OfferErrorDetails errorDetails = new OfferErrorDetails(ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
