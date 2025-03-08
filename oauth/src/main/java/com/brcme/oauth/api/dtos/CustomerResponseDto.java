package com.brcme.oauth.api.dtos;

import java.util.Set;
import java.util.UUID;

public record CustomerResponseDto(
	UUID id,
	String name,
	String email,
	Set<String> roles) {}
