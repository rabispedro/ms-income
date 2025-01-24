package com.brcme.payroll.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name = "worker-api-client")
@EnableFeignClients
@SpringBootApplication
public class PayrollApplication {
	public static void main(String[] args) {
		SpringApplication.run(PayrollApplication.class, args);
	}
}
