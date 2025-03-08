package com.brcme.oauth.api.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brcme.oauth.api.dtos.CustomerResponseDto;
import com.brcme.oauth.api.services.CustomerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {
	private final CustomerService customerService;

	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponseDto> getById(
		@PathVariable("id") UUID id) {

		return ResponseEntity.ok(customerService.findById(id));
	}

	@GetMapping("/search")
	public ResponseEntity<CustomerResponseDto> findByEmail(
		@RequestParam("email") String email) {

		return ResponseEntity.ok(customerService.findByEmail(email));
	}
}
