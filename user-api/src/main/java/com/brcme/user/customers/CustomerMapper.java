package com.brcme.user.customers;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.brcme.user.customers.dtos.CreateCustomerRequestDto;
import com.brcme.user.customers.dtos.CustomerResponseDto;
import com.brcme.user.roles.Role;
import com.brcme.user.roles.dtos.RoleResponseDto;

@Component
public class CustomerMapper {
	private CustomerMapper() {}

	public static Customer toEntity(CreateCustomerRequestDto customerDto, Set<RoleResponseDto> rolesDto) {
		Set<Role> roles = rolesDto
			.stream()
			.map(role -> Role
				.builder()
				.id(role.id())
				.name(role.name())
				.build())
			.collect(Collectors.toSet());

		return Customer
			.builder()
			.name(customerDto.name())
			.email(customerDto.email())
			.password(customerDto.password())
			.roles(roles)
			.build();
	}

	public static CustomerResponseDto toDto(Customer customer) {
		return new CustomerResponseDto(
			customer.getId(),
			customer.getName(),
			customer.getEmail(),
			customer.getRoles().stream().map(Role::getName).collect(Collectors.toSet()));
	}
}
