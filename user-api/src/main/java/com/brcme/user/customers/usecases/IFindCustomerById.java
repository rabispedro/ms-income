package com.brcme.user.customers.usecases;

import java.util.UUID;

import com.brcme.user.customers.dtos.CustomerResponseDto;

public interface IFindCustomerById {
	CustomerResponseDto execute(UUID id);
}
