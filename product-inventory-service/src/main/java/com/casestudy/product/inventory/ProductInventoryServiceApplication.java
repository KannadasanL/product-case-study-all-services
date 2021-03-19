package com.casestudy.product.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductInventoryServiceApplication.class, args);
		System.out.println("***************Product-Inventory-services application started and running on port 6004****************");
	}

}
