package com.brcme.user.customers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brcme.user.customers.dtos.CreateCustomerRequestDto;
import com.brcme.user.customers.dtos.CustomerResponseDto;
import com.brcme.user.customers.usecases.ICreateCustomerUseCase;
import com.brcme.user.customers.usecases.IFindCustomerByEmailUseCase;
import com.brcme.user.customers.usecases.IFindCustomerById;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {
	private final ICreateCustomerUseCase createCustomerUseCase;
	private final IFindCustomerByEmailUseCase findCustomerByEmailUseCase;
	private final IFindCustomerById findCustomerById;

	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponseDto> getById(
		@PathVariable("id") UUID id) {

		return ResponseEntity.ok(findCustomerById.execute(id));
	}
	
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
