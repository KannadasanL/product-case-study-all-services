package com.casestudy.product.service.service;

public interface RestService {

	public Price getPriceForProductId(long id);
	
	public Offer getOfferForProductId(long id);
	
	public Inventory getQuantityForProductId(long id);
}
