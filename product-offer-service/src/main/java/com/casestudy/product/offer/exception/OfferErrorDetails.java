package com.casestudy.product.offer.exception;

import lombok.Data;

@Data
public class OfferErrorDetails {

	private String message;
	public OfferErrorDetails(String message) {
		this.message = message;
	}
}
