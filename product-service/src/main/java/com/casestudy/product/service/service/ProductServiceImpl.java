package com.casestudy.product.service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.product.service.domain.ProductResponse;
import com.casestudy.product.service.entity.Product;
import com.casestudy.product.service.repository.ProductRepository;
import com.casestudy.product.service.util.ResourceNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private RestService restService;
	
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return products;
	}
	
	@Override
	public List<ProductResponse> getAllProductsResponse() {
		List<ProductResponse> productResponseList = new ArrayList<>();
		List<Product> products = productRepository.findAll();
		for (Product p: products) {
			ProductResponse presonse = new ProductResponse(p.getId(), p.getName(), p.getBrand(), p.getMadeIn());
			presonse.setPrice(restService.getPriceForProductId(p.getId()).getPriceValue());
			presonse.setDiscount(restService.getOfferForProductId(p.getId()).getOfferPercent());
			presonse.setQuantity(restService.getQuantityForProductId(p.getId()).getQuantity());
			productResponseList.add(presonse);
		}
		return productResponseList;
	}

	@Override
	public Product getProductById(Long id) throws ResourceNotFoundException {
		return productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not found for this product id::" + id));
		}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public void deleteAllProduct() {
		productRepository.deleteAll();
	}


	
}
