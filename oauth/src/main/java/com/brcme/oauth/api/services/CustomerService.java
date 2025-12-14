package com.brcme.oauth.api.services;

import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.brcme.oauth.api.dtos.CustomerResponseDto;
import com.brcme.oauth.api.repositories.CustomerRepository;

@Service
public class CustomerService implements UserDetailsService {
	private final Logger logger = LoggerFactory.getLogger(CustomerService.class);
	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public CustomerResponseDto findById(UUID id) {
		CustomerResponseDto customerDto = customerRepository.getById(id).getBody();
		logger.info("Customer by id: {}", customerDto);

		if (customerDto == null) {
			throw new IllegalArgumentException("Customer with this id not found");
		}

		return customerDto;
	}

	public CustomerResponseDto findByEmail(String email) {
		CustomerResponseDto customerDto = customerRepository.getByEmail(email).getBody();
		logger.info("Customer by email: {}", customerDto);

		if (customerDto == null) {
			throw new IllegalArgumentException("Customer with this email not found");
		}

		return customerDto;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomerResponseDto customerDto = customerRepository.getByEmail(username).getBody();
		logger.info("Customer loaded by email: {}", customerDto);

		if (customerDto == null) {
			throw new UsernameNotFoundException("Customer not found");
		}

		return customerDto;
	}
}
