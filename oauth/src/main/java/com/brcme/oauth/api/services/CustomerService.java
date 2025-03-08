package com.brcme.oauth.api.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.brcme.oauth.api.dtos.CustomerResponseDto;
import com.brcme.oauth.api.repositories.CustomerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomerService {
	private final CustomerRepository customerRepository;

	public CustomerResponseDto findById(UUID id) {
		CustomerResponseDto customerDto = customerRepository.getById(id).getBody();

		if (customerDto == null) {
			throw new RuntimeException("Customer not found");
		}

		return customerDto;
	}

	public CustomerResponseDto findByEmail(String email) {
		CustomerResponseDto customerDto = customerRepository.getByEmail(email).getBody();

		if (customerDto == null) {
			throw new RuntimeException("Customer not found");
		}

		return customerDto;
	}
}
