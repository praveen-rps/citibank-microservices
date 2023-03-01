package com.example.citigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CitiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitiGatewayApplication.class, args);
	}
}
