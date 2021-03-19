package com.casestudy.product.offer.service;

import com.casestudy.product.offer.entity.Offer;
import com.casestudy.product.offer.exception.OfferNotFound;

public interface OfferService {

	public Offer getOfferById(long id) throws OfferNotFound;
	
	public Offer addOffer(Offer offer);
	
	public void deleteOfferById(long id) throws OfferNotFound;
	
	public void deleteAllOffers();
}
