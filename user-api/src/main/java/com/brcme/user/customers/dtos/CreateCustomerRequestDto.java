package com.brcme.user.customers.dtos;

import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record CreateCustomerRequestDto(
	@NotEmpty(message = "name is required")
	String name,

	@NotEmpty(message = "email is required")
	@Email(message = "invalid email formate")
	String email,

	@NotEmpty(message = "password is required")
	String password,

	Set<String> roles) {}
