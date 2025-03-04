package com.brcme.user.customers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brcme.user.customers.dtos.CreateCustomerRequestDto;
import com.brcme.user.customers.dtos.CustomerResponseDto;
import com.brcme.user.customers.usecases.ICreateCustomerUseCase;
import com.brcme.user.customers.usecases.IFindCustomerByEmailUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {
	private final ICreateCustomerUseCase createCustomerUseCase;
	private final IFindCustomerByEmailUseCase findCustomerByEmailUseCase;

	@PostMapping
	public ResponseEntity<Void> createCustomer(
		@RequestBody @Valid CreateCustomerRequestDto customerDto) {

		createCustomerUseCase.execute(customerDto);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/search")
	public ResponseEntity<CustomerResponseDto> getByEmail(
		@RequestParam("email") String email) {

		return ResponseEntity.ok(findCustomerByEmailUseCase.execute(email));
	}
}
