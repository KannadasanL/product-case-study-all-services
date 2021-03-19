package com.casestudy.product.inventory.controller;

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

import com.casestudy.product.inventory.entity.Inventory;
import com.casestudy.product.inventory.exception.InventoryNotFound;
import com.casestudy.product.inventory.service.InventoryService;

@RestController
@RequestMapping("/case-study")
public class InventoryController {

	@Value("${spring.application.name}")
	private String appName;
	
	@Autowired
	private InventoryService invenService;
	
	@GetMapping("/message")
	public String getAppName() {
		return "I am in "+appName;
	}
	
	@GetMapping("/inventories/{id}")
	public ResponseEntity<Inventory> getQuantityForProduct(@PathVariable(value = "id") long productId)
			throws InventoryNotFound {
		Inventory inven = invenService.getQuantityById(productId);
		return ResponseEntity.ok().body(inven);
	}
	
	@PostMapping("/inventories")
	public ResponseEntity<Inventory> addQuantityForProduct(@Validated @RequestBody Inventory inven) {
		Inventory savedInven = invenService.addQuantity(inven);
		return ResponseEntity.ok().body(savedInven);
	}
	
	@PutMapping("/inventories/{id}")
	public ResponseEntity<Inventory> updateQuantityForProduct(@PathVariable(value = "id") long id, @Validated @RequestBody Inventory inve) 
			throws InventoryNotFound {
		Inventory fetchedInven = invenService.getQuantityById(id);
		fetchedInven.setQuantity(inve.getQuantity());
		final Inventory updatedInven = invenService.addQuantity(fetchedInven);
		return ResponseEntity.ok().body(updatedInven);
	}
	
	@DeleteMapping("/inventories/{id}")
	public ResponseEntity<?> deleteQuantityForProduct(@PathVariable(value = "id") long id) throws InventoryNotFound	 {
		invenService.deleteQuantityById(id);
		return new ResponseEntity<>("Quantity for this product id "+id +" has been deleted!!!",HttpStatus.OK);
	}	
}
