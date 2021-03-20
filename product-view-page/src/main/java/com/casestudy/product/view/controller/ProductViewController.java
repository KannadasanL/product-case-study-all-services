package com.casestudy.product.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.product.view.model.Product;
import com.casestudy.product.view.service.ProductViewService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/case-study")
@Slf4j
public class ProductViewController {

	@Value("${spring.application.name}")
	private String appName;
	
	@Autowired
	private ProductViewService viewService;
	
	@GetMapping("/message")
	public String getAppName() {
		log.info("getAppName::{}", appName );
		return "I am in "+appName;
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value = "id") long id) {
		log.info("Calling getProductById from ProductViewController");
		Product product = viewService.getProductsById(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@GetMapping("/products")
	public ResponseEntity<?> getAllProducts() {
		log.info("Calling getAllProducts from ProductViewController");
		List<Product> product = viewService.getAllProducts();
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
}
