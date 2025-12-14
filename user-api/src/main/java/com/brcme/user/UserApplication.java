package com.brcme.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.modulith.Modulithic;
import org.springframework.modulith.core.ApplicationModules;

@EnableDiscoveryClient
@Modulithic(systemName = "user-api")
@SpringBootApplication
public class UserApplication {
	public static void main(String[] args) {
		var modules = ApplicationModules.of(UserApplication.class);
		modules.verify();

		SpringApplication.run(UserApplication.class, args);
	}
}
