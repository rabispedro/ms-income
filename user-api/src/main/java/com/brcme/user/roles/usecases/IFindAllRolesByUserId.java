package com.brcme.user.roles.usecases;

import java.util.UUID;

import com.brcme.user.customers.dtos.CustomerResponseDto;

public interface IFindRoleByUserId {
	RoleResponseDto execute(UUID userId);
}
