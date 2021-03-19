package com.casestudy.product.price.service;

import java.util.Map;

import com.casestudy.product.price.entity.Price;
import com.casestudy.product.price.exception.ResourceNotFoundException;

public interface PriceService {
	
	public Price getPriceByProductId(long productId) throws ResourceNotFoundException;
	
	public Price addPrice(Price price);
	
	public Map<String, Boolean> deleteProductPrice(long productId) throws ResourceNotFoundException;

}
