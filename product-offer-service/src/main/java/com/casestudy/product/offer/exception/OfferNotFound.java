package com.casestudy.product.offer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OfferNotFound extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OfferNotFound(String message) {
		super(message);
	}

}
