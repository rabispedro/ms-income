package com.brcme.user.roles.usecases;

import java.util.UUID;

import com.brcme.user.roles.dtos.RoleResponseDto;

public interface IFindRoleById {
	RoleResponseDto execute(UUID id);
}
