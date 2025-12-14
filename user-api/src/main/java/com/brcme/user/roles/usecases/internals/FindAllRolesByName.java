package com.brcme.user.roles.usecases.internals;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.brcme.user.roles.Role;
import com.brcme.user.roles.RoleMapper;
import com.brcme.user.roles.RoleRepository;
import com.brcme.user.roles.dtos.RoleListResponseDto;
import com.brcme.user.roles.usecases.IFindAllRolesByName;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
class FindAllRolesByName implements IFindAllRolesByName {
	private final RoleRepository roleRepository;

	@Override
	public RoleListResponseDto execute(Set<String> names) {
		Set<Role> roles = roleRepository.findAllByName(names);

		return RoleMapper.toDtoList(roles);
	}
	
}
