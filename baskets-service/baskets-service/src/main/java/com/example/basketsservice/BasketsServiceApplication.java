package com.example.basketsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BasketsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasketsServiceApplication.class, args);
	}

}
