package com.casestudy.product.offer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.product.offer.entity.Offer;
import com.casestudy.product.offer.exception.OfferNotFound;
import com.casestudy.product.offer.service.OfferService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/case-study")
@Slf4j
public class OfferController {

	@Value("${spring.application.name}")
	private String appName;
	
	@Autowired
	private OfferService offerService;
	
	@GetMapping("/message")
	public String getAppName() {
		log.info("appName: {}", appName);
		return "I am in "+appName;
	}
	
	@GetMapping("/offers/{id}")
	public ResponseEntity<Offer> getOfferForProduct(@PathVariable(value = "id") long productId)
			throws OfferNotFound {
		log.info("calling getOfferForProduct from OfferController");
		Offer offer = offerService.getOfferById(productId);
		return ResponseEntity.ok().body(offer);
	}
	
	@PostMapping("/offers")
	public ResponseEntity<Offer> addOfferForProduct(@Validated @RequestBody Offer offer) {
		log.info("calling addOfferForProduct from OfferController");
		Offer savedOffer = offerService.addOffer(offer);
		return ResponseEntity.ok().body(savedOffer);
	}
	
	@PutMapping("/offers/{id}")
	public ResponseEntity<Offer> updateOfferForProduct(@PathVariable(value = "id") long id, @Validated @RequestBody Offer offer) 
			throws OfferNotFound {
		log.info("calling updateOfferForProduct from OfferController");
		Offer fetchedOffer = offerService.getOfferById(id);
		fetchedOffer.setOfferPercent(offer.getOfferPercent());
		final Offer updatedOffer = offerService.addOffer(fetchedOffer);
		return ResponseEntity.ok().body(updatedOffer);
	}
	
	@DeleteMapping("/offers/{id}")
	public ResponseEntity<?> deleteOfferForProduct(@PathVariable(value = "id") long id) throws OfferNotFound {
		log.info("calling deleteOfferForProduct from OfferController");
		offerService.deleteOfferById(id);
		return new ResponseEntity<>("Offer for this product id "+id +" has been deleted!!!",HttpStatus.OK);
	}	
}
