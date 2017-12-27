package com.example.calculatorgui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CalculatorGuiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorGuiApplication.class, args);
	}
}
