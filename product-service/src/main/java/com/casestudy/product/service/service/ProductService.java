package com.casestudy.product.service.service;

import java.util.List;

import com.casestudy.product.service.domain.ProductResponse;
import com.casestudy.product.service.entity.Product;
import com.casestudy.product.service.util.ResourceNotFoundException;

public interface ProductService {

	public List<Product> getAllProducts();
	
	public Product getProductById(Long id) throws ResourceNotFoundException;
	
	public Product addProduct(Product product);
	
	public void deleteProduct(Long id);
	
	public void deleteAllProduct();

	List<ProductResponse> getAllProductsResponse();

}
