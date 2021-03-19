package com.casestudy.product.view.service;

import java.util.List;

import com.casestudy.product.view.model.Product;

public interface ProductViewService {

	public Product getProductsById(long id);
	
	public List<Product> getAllProducts();
}
