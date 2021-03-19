package com.casestudy.product.inventory.exception;

import lombok.Data;

@Data
public class InventoryErrorDetails {

	private String message;
	public InventoryErrorDetails(String message) {
		this.message = message;
	}
}
