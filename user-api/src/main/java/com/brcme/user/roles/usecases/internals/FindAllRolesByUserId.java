package com.brcme.user.roles.usecases.internals;

import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.brcme.user.roles.Role;
import com.brcme.user.roles.RoleMapper;
import com.brcme.user.roles.RoleRepository;
import com.brcme.user.roles.dtos.RoleListResponseDto;
import com.brcme.user.roles.usecases.IFindAllRolesByUserId;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
class FindAllRolesByUserId implements IFindAllRolesByUserId {
	private final RoleRepository roleRepository;

	@Override
	public RoleListResponseDto execute(UUID userId) {
		Set<Role> roles = roleRepository.findAllByUserId(userId);

		return RoleMapper.toDtoList(roles);
	}
}
