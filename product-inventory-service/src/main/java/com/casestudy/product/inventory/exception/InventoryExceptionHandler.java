package com.casestudy.product.inventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InventoryExceptionHandler {
	
	@ExceptionHandler(InventoryNotFound.class)
	public ResponseEntity<?> offerNotFound(InventoryNotFound ex) {
		InventoryErrorDetails errorDetails = new InventoryErrorDetails(ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> otherExceptions(Exception ex) {
		InventoryErrorDetails errorDetails = new InventoryErrorDetails(ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
