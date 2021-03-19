package com.casestudy.product.service.domain;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

	private String name;
	
	private String brand;
	
	private String madeIn;
}
