package com.brcme.user.customers.usecases.internals;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.brcme.user.customers.Customer;
import com.brcme.user.customers.CustomerMapper;
import com.brcme.user.customers.CustomerRepository;
import com.brcme.user.customers.dtos.CreateCustomerRequestDto;
import com.brcme.user.customers.dtos.CustomerResponseDto;
import com.brcme.user.customers.usecases.ICreateCustomerUseCase;
import com.brcme.user.roles.dtos.RoleListResponseDto;
import com.brcme.user.roles.usecases.IFindAllRolesByName;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
class CreateCustomerUseCase implements ICreateCustomerUseCase {
	private final BCryptPasswordEncoder passwordEncoder;

	private final CustomerRepository customerRepository;
	private final IFindAllRolesByName findAllRolesByName;

	@Override
	public CustomerResponseDto execute(CreateCustomerRequestDto customerDto) {
		CreateCustomerRequestDto newCustomerDto = new CreateCustomerRequestDto(
			customerDto.name(),
			customerDto.email(),
			passwordEncoder.encode(customerDto.password()),
			customerDto.roles());

		RoleListResponseDto roles = findAllRolesByName.execute(newCustomerDto.roles());
		Customer customer = CustomerMapper.toEntity(newCustomerDto, roles.content());

		customerRepository.save(customer);

		return CustomerMapper.toDto(customer);
	}
}
