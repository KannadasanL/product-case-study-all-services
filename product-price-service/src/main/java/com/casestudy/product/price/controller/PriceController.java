package com.casestudy.product.price.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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

import com.casestudy.product.price.entity.Price;
import com.casestudy.product.price.exception.ResourceNotFoundException;
import com.casestudy.product.price.service.PriceService;

@RestController
@RequestMapping("/case-study")
@RefreshScope
public class PriceController {

	@Value("${spring.application.name}")
	private String appName;
	
	@Autowired
	private PriceService priceService;
	
	@GetMapping("/message")
	public String getAppName() {
		return "I am in "+appName;
	}
	
	@GetMapping("/prices/{id}")
	public ResponseEntity<Price> getPriceForProduct(@PathVariable(value = "id") long productId)
			throws ResourceNotFoundException {
		Price price = priceService.getPriceByProductId(productId);
		return ResponseEntity.ok().body(price);
	}
	
	@PostMapping("/prices")
	public ResponseEntity<Price> addPriceForProduct(@Validated @RequestBody Price price) {
		Price savedPrice = priceService.addPrice(price);
		return ResponseEntity.ok().body(savedPrice);
	}
	
	@PutMapping("/prices/{id}")
	public ResponseEntity<Price> updatePriceForProduct(@PathVariable(value = "id") long id, @Validated @RequestBody Price price) 
			throws ResourceNotFoundException {
		Price fetchedPrice = priceService.getPriceByProductId(id);
		fetchedPrice.setPriceValue(price.getPriceValue());
		final Price updatedPrice = priceService.addPrice(fetchedPrice);
		return ResponseEntity.ok().body(updatedPrice);
	}
	
	@DeleteMapping("/prices/{id}")
	public ResponseEntity<?> deletePriceForProduct(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
		Map<String, Boolean> responseMap = priceService.deleteProductPrice(id);
		return ResponseEntity.ok().body(responseMap);
	}
}
