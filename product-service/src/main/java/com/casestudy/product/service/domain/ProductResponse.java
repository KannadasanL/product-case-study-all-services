package com.casestudy.product.service.domain;



import lombok.Data;

@Data
public class ProductResponse {
	public ProductResponse(long id2, String name2, String brand2, String madeIn2) {
		this.id = id2;
		this.name = name2;
		this.brand = brand2;
		this.madeIn = madeIn2;
	}
	
	public ProductResponse() {
		
	}
	private long id;
	private String name;
	private String brand;
	private String madeIn;
	private double price;
	private float discount;
	private int quantity;
}
