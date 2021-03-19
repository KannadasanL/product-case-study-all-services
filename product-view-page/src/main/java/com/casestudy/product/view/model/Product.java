package com.casestudy.product.view.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private long id;
	private String name;
	private String brand;
	private String madeIn;
	private double price;
	private float discount;
	private int quantity;
	
}
