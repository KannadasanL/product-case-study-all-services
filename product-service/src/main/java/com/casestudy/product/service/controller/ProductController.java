package com.casestudy.product.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
import org.springframework.web.client.RestTemplate;

import com.casestudy.product.service.domain.ProductRequest;
import com.casestudy.product.service.domain.ProductResponse;
import com.casestudy.product.service.entity.Product;
import com.casestudy.product.service.service.Inventory;
import com.casestudy.product.service.service.Offer;
import com.casestudy.product.service.service.Price;
import com.casestudy.product.service.service.ProductService;
import com.casestudy.product.service.service.RestService;
import com.casestudy.product.service.util.ProductCustomMessage;
import com.casestudy.product.service.util.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/case-study")
@Slf4j
@RefreshScope
public class ProductController {

	@Value("${spring.application.name}")
	private String applicationName;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RestService restService;

	@GetMapping("/message")
	public String getMessage() {
		return "I am " + applicationName;
	}

/*	@GetMapping("/products/{id}")
	public ResponseEntity<?> getProduct(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		Product productAvailable = productService.getProductById(id);
		return ResponseEntity.ok().body(productAvailable);
	}*/
	
	@GetMapping("/products/{id}")
	public ResponseEntity<?> getProduct(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		Product productAvailable = productService.getProductById(id);
		Price price = restService.getPriceForProductId(id);
		ProductResponse productResponse = new ProductResponse();
		productResponse.setId(productAvailable.getId());
		productResponse.setName(productAvailable.getName());
		productResponse.setBrand(productAvailable.getBrand());
		productResponse.setMadeIn(productAvailable.getMadeIn());
		productResponse.setPrice(price.getPriceValue());
		
		Offer offer = restService.getOfferForProductId(id);
		productResponse.setDiscount(offer.getOfferPercent());
		
		Inventory inventory = restService.getQuantityForProductId(id);
		productResponse.setQuantity(inventory.getQuantity());
		
		return ResponseEntity.ok().body(productResponse);
	}	

	@GetMapping("/products/")
	public ResponseEntity<?> getAllProducts() {
		List<Product> allProducts = productService.getAllProducts();
		if (allProducts.size() <= 0) {
			log.info("no products available");
			return new ResponseEntity<>(new ProductCustomMessage("No Products Available at this time"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(allProducts, HttpStatus.OK);
	}
	
	@GetMapping("/products")
	public ResponseEntity<?> getAllProducts1() {
		List<ProductResponse> allProducts = productService.getAllProductsResponse();
		if (allProducts.size() <= 0) {
			log.info("no products available");
			return new ResponseEntity<>(new ProductCustomMessage("No Products Available at this time"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(allProducts, HttpStatus.OK);
	}

	@PostMapping("/products")
	public ResponseEntity<?> addProduct(@Validated @RequestBody ProductRequest productRequest) {
		if (null == productRequest) {
			log.info("productRequest is null!!");
			return new ResponseEntity<>(new ProductCustomMessage("productRequest is empty or null"), HttpStatus.BAD_REQUEST);
		}
		Product product = new Product();
		product.setName(productRequest.getName());
		product.setBrand(productRequest.getBrand());
		product.setMadeIn(productRequest.getMadeIn());
		Product savedProduct = productService.addProduct(product);
		log.info("savedProduct:::" + savedProduct);
		
		ProductResponse productResponse = new ProductResponse();
		productResponse.setId(savedProduct.getId());
		productResponse.setName(savedProduct.getName());
		productResponse.setBrand(savedProduct.getBrand());
		productResponse.setMadeIn(savedProduct.getMadeIn());
		
		Price price = restService.getPriceForProductId(savedProduct.getId());
		productResponse.setPrice(price.getPriceValue());
		
		Offer offer = restService.getOfferForProductId(savedProduct.getId());
		productResponse.setDiscount(offer.getOfferPercent());
		
		Inventory inventory = restService.getQuantityForProductId(savedProduct.getId());
		productResponse.setQuantity(inventory.getQuantity());
		
		return ResponseEntity.ok().body(productResponse);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable(value = "id") Long id, @Validated @RequestBody Product product)
			throws ResourceNotFoundException {
		Product existingProduct = productService.getProductById(id);
		existingProduct.setId(id);
		final Product updateProduct = productService.addProduct(existingProduct);
		log.info("product {} is updated", updateProduct);
		return ResponseEntity.ok().body(updateProduct);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> deleteProductById(@PathVariable Long id) {
		productService.deleteProduct(id);
		log.info("product is deleted for id : {}", id);
		return new ResponseEntity<>("Product is deleted successfully!!", HttpStatus.OK);
	}

	@DeleteMapping("/products")
	public ResponseEntity<?> deleteProductById() {
		productService.deleteAllProduct();
		log.info("All products deleted successfully!!");
		return new ResponseEntity<>("All Products are deleted successfully!!", HttpStatus.OK);
	}
	
	@GetMapping("/products/prices/{id}")
	public ResponseEntity<Price> getPriceForProductId(@PathVariable(value = "id") long productId) {
		Price price = restTemplate.getForObject("http://product-price-service/case-study/prices/"+productId, Price.class);
		return ResponseEntity.ok().body(price);
	}

}
