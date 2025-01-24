package com.brcme.payroll.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class PayrollApplication {
	public static void main(String[] args) {
		SpringApplication.run(PayrollApplication.class, args);
	}
}
