package com.brcme.user.customers.usecases;

import com.brcme.user.customers.dtos.CustomerResponseDto;

public interface IFindCustomerByEmailUseCase {
	CustomerResponseDto execute(String email);
}
