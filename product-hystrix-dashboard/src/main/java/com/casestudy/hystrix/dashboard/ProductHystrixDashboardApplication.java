package com.casestudy.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
@EnableEurekaClient
public class ProductHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductHystrixDashboardApplication.class, args);
	}

}
