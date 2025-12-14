package com.brcme.user.customers.usecases.internals;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.brcme.user.customers.Customer;
import com.brcme.user.customers.CustomerMapper;
import com.brcme.user.customers.CustomerRepository;
import com.brcme.user.customers.dtos.CustomerResponseDto;
import com.brcme.user.customers.usecases.IFindCustomerById;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindCustomerById implements IFindCustomerById {
	private final CustomerRepository customerRepository;
	
	@Override
	public CustomerResponseDto execute(UUID id) {
		Optional<Customer> customer = customerRepository.findById(id);

		if (!customer.isPresent()) {
			throw new RuntimeException("Customer not found");
		}

		return CustomerMapper.toDto(customer.get());
	}
}
