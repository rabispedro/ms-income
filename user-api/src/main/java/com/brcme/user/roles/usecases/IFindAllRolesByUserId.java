package com.brcme.user.roles.usecases;

import java.util.UUID;

import com.brcme.user.roles.dtos.RoleListResponseDto;

public interface IFindAllRolesByUserId {
	RoleListResponseDto execute(UUID userId);
}
