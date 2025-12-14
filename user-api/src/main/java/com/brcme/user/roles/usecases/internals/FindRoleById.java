package com.brcme.user.roles.usecases.internals;

import java.util.Optional;
import java.util.UUID;


import org.springframework.stereotype.Service;

import com.brcme.user.roles.Role;
import com.brcme.user.roles.RoleMapper;
import com.brcme.user.roles.RoleRepository;
import com.brcme.user.roles.dtos.RoleResponseDto;
import com.brcme.user.roles.usecases.IFindRoleById;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
class FindRoleById implements IFindRoleById {
	private final RoleRepository roleRepository;

	@Override
	public RoleResponseDto execute(UUID id) {
		Optional<Role> role = roleRepository.findById(id);

		if (!role.isPresent()) {
			throw new RuntimeException("Role not found");
		}

		return RoleMapper.toDto(role.get());
	}
}
