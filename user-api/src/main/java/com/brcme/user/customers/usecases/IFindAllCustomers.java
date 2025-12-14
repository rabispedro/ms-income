package com.brcme.user.customers.usecases;

import java.util.List;

import com.brcme.user.customers.dtos.CustomerResponseDto;

public interface IFindAllCustomers {
	List<CustomerResponseDto> execute();
}
