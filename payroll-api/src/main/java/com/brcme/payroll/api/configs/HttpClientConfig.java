package com.brcme.payroll.api.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpClientConfig {
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
