package com.casestudy.product.view.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.casestudy.product.view.model.Product;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductViewServiceImpl implements ProductViewService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${product.service.gateway.url}")
	private String gatewayUrl;
	
	@Value("${product.service.context.uri}")
	private String uri;
	
	@Override
	public Product getProductsById(long id) {
		log.info("calling product service through gateway:: {} ", gatewayUrl+uri+"/"+id);
		Product product = restTemplate.getForObject(gatewayUrl+uri+"/"+id, Product.class);
		return product;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProducts() {
		log.info("calling product service through gateway:: {} ", gatewayUrl+uri);
		List<Product> products = (List<Product>) restTemplate.getForObject(gatewayUrl+uri, Object.class);
		return products;
	}

}
