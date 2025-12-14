package com.brcme.user.customers.usecases.internals;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brcme.user.customers.Customer;
import com.brcme.user.customers.CustomerMapper;
import com.brcme.user.customers.CustomerRepository;
import com.brcme.user.customers.dtos.CustomerResponseDto;
import com.brcme.user.customers.usecases.IFindCustomerByEmailUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindCustomerByEmailUseCase implements IFindCustomerByEmailUseCase{
	private final CustomerRepository customerRepository;
	
	@Override
	public CustomerResponseDto execute(String email) {
		Optional<Customer> customer = customerRepository.findByEmail(email);
		
		if (!customer.isPresent()) {
			throw new RuntimeException("Customer not found");
		}

		return CustomerMapper.toDto(customer.get());
	}
}
