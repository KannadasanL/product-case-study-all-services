package com.casestudy.product.service.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ProductServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceRegistryApplication.class, args);
		System.out.println("***************Product-Service-Registry application started and running on port 8761*************");
	}

}
