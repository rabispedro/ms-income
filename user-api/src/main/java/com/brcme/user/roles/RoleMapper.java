package com.brcme.user.roles;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.brcme.user.roles.dtos.RoleListResponseDto;
import com.brcme.user.roles.dtos.RoleResponseDto;

@Component
public class RoleMapper {
	private RoleMapper() {}

	public static RoleResponseDto toDto(Role role) {
		return new RoleResponseDto(
			role.getId(),
			role.getName());
	}

	public static RoleListResponseDto toDtoList(Set<Role> roles) {
		Set<RoleResponseDto> content = roles
			.stream()
			.map(RoleMapper::toDto)
			.collect(Collectors.toSet());

		Integer size = content.size();

		return new RoleListResponseDto(
			content,
			size);
	}
}
