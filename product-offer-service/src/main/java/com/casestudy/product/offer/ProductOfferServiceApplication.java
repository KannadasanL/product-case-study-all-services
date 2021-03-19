package com.casestudy.product.offer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductOfferServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductOfferServiceApplication.class, args);
	}

}
