package com.brcme.user.roles.usecases;

import java.util.Set;

import com.brcme.user.roles.dtos.RoleListResponseDto;

public interface IFindAllRolesByName {
	RoleListResponseDto execute(Set<String> names);
}
