package com.brcme.oauth.api.repositories;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.brcme.oauth.api.dtos.CustomerResponseDto;

@FeignClient(name = "user-api", path = "/customers")
@Component
public interface CustomerRepository {
	@GetMapping("/{id}")
	ResponseEntity<CustomerResponseDto> getById(@PathVariable("id") UUID id);

	@GetMapping("/search")
	public ResponseEntity<CustomerResponseDto> getByEmail(@RequestParam("email") String email);
}
