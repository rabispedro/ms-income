package com.brcme.user.roles.dtos;

import java.util.UUID;

public record RoleResponseDto(
	UUID id,
	String name) {}
