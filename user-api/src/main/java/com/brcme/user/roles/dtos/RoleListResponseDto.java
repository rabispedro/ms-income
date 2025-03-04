package com.brcme.user.roles.dtos;

import java.util.Set;

public record RoleListResponseDto(
	Set<RoleResponseDto> content,
	Integer size) {}
