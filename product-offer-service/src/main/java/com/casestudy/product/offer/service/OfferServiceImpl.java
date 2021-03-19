package com.casestudy.product.offer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.product.offer.entity.Offer;
import com.casestudy.product.offer.exception.OfferNotFound;
import com.casestudy.product.offer.repository.OfferRepository;

@Service
public class OfferServiceImpl implements OfferService{
	
	@Autowired
	private OfferRepository offerRepo;

	@Override
	public Offer getOfferById(long id) throws OfferNotFound{
		return offerRepo.findById(id)
		.orElseThrow(() -> new OfferNotFound("Offer is not found this product id::" + id));
	}

	@Override
	public Offer addOffer(Offer offer) {
		return offerRepo.save(offer);
	}

	@Override
	public void deleteOfferById(long id) throws OfferNotFound {
		Offer offer = getOfferById(id);
		offerRepo.delete(offer);
	}

	@Override
	public void deleteAllOffers() {
		offerRepo.deleteAll();
	}

}
