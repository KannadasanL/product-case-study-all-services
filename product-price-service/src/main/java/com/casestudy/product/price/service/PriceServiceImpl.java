package com.casestudy.product.price.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.product.price.entity.Price;
import com.casestudy.product.price.exception.ResourceNotFoundException;
import com.casestudy.product.price.repository.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService {
	
	@Autowired
	private PriceRepository priceRepo;

	@Override
	public Price getPriceByProductId(long productId) throws ResourceNotFoundException {
		return priceRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not found for this product id::" + productId));
	}

	@Override
	public Price addPrice(Price price) {
		return priceRepo.save(price);
	}

	@Override
	public Map<String, Boolean> deleteProductPrice(long productId) throws ResourceNotFoundException {
		Price price = getPriceByProductId(productId);
		priceRepo.delete(price);
		Map<String, Boolean> responseMap = new HashMap<>();
		responseMap.put("deleted", Boolean.TRUE);
		return responseMap;
	}
	
	

}
