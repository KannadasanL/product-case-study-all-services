package com.casestudy.product.view.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductViewExceptionHandler {
	
	@ExceptionHandler(ProductViewNotFound.class)
	public ResponseEntity<?> offerNotFound(ProductViewNotFound ex) {
		ProductViewErrorDetails errorDetails = new ProductViewErrorDetails(ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> otherExceptions(Exception ex) {
		ProductViewErrorDetails errorDetails = new ProductViewErrorDetails(ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
