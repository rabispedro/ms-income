package com.brcme.user.customers.dtos;

import java.util.Set;
import java.util.UUID;

public record CustomerResponseDto(
	UUID id,
	String name,
	String email,
	String password,
	Set<String> roles) {}
