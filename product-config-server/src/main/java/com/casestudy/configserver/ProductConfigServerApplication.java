package com.casestudy.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ProductConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductConfigServerApplication.class, args);
		System.out.println("*************Product-Config-Server application started and running on port 8888******************");
	}

}
