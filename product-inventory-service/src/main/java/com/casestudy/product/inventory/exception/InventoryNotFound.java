package com.casestudy.product.inventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InventoryNotFound extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InventoryNotFound(String message) {
		super(message);
	}

}
