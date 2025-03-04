package com.brcme.user.customers.usecases;

import com.brcme.user.customers.dtos.CreateCustomerRequestDto;
import com.brcme.user.customers.dtos.CustomerResponseDto;

public interface ICreateCustomerUseCase {
	CustomerResponseDto execute(CreateCustomerRequestDto customerDto);
}
