package com.brcme.payroll.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brcme.payroll.api.entities.Payment;
import com.brcme.payroll.api.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@RestController
@RequestMapping("/payments")
public class PaymentController {
	private final PaymentService paymentService;

	@HystrixCommand(fallbackMethod = "getFallback")
	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(
		@Parameter(name = "workerId") @PathVariable("workerId") UUID workerId,
		@Parameter(name = "days") @PathVariable("days") Integer days) {

		return ResponseEntity.ok(paymentService.getPayment(workerId, days));
	}

	public ResponseEntity<Object> getFallback(
		UUID workerId,
		Integer days) {

		return ResponseEntity
			.of(ProblemDetail.forStatus(HttpStatus.I_AM_A_TEAPOT.value()))
			.build();
	}
}
