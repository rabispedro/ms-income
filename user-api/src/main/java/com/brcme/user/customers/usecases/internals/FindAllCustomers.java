package com.brcme.user.customers.usecases.internals;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brcme.user.customers.Customer;
import com.brcme.user.customers.CustomerMapper;
import com.brcme.user.customers.CustomerRepository;
import com.brcme.user.customers.dtos.CustomerResponseDto;
import com.brcme.user.customers.usecases.IFindAllCustomers;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindAllCustomers implements IFindAllCustomers {
	private final CustomerRepository customerRepository;

	@Override
	public List<CustomerResponseDto> execute() {
		List<Customer> customers = customerRepository.findAll();

		return customers
			.stream()
			.map(CustomerMapper::toDto)
			.toList();
	}
}
