package com.casestudy.product.price;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductPriceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductPriceServiceApplication.class, args);
	}

}
