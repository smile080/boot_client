package com.ini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RunApplicationClient {

	public static void main(String[] args) {
		SpringApplication.run(RunApplicationClient.class, args);
	}
}
