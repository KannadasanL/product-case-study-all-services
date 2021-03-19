package com.casestudy.product.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RestServiceImpl implements RestService {

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	@HystrixCommand(fallbackMethod = "getPriceForProductId_fallback")
	public Price getPriceForProductId(long id) {
		Price price = restTemplate.getForObject("http://product-price-service/case-study/prices/"+id, Price.class);
		return price;
	}

	
	public Price getPriceForProductId_fallback(long id) {
		return new Price();
	}


	@Override
	@HystrixCommand(fallbackMethod = "getOfferForProductId_fallback")
	public Offer getOfferForProductId(long id) {
		Offer offer = restTemplate.getForObject("http://product-offer-service/case-study/offers/"+id, Offer.class);
		return offer;
	}
	
	
	public Offer getOfferForProductId_fallback(long id) {
		return new Offer();
	}


	@Override
	@HystrixCommand(fallbackMethod = "getQuantityForProductId_fallback")
	public Inventory getQuantityForProductId(long id) {
		Inventory inventory = restTemplate.getForObject("http://product-inventory-service/case-study/inventories/"+id, Inventory.class);
		return inventory;
	}
	
	
	public Inventory getQuantityForProductId_fallback(long id) {
		return new Inventory();
	}
	
}
