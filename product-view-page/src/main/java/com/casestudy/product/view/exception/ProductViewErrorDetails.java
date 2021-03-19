package com.casestudy.product.view.exception;

import lombok.Data;

@Data
public class ProductViewErrorDetails {

	private String message;
	public ProductViewErrorDetails(String message) {
		this.message = message;
	}
}
