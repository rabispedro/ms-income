package com.brcme.payroll.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brcme.payroll.api.entities.Payment;
import com.brcme.payroll.api.services.PaymentService;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@RestController
@RequestMapping("/payments")
public class PaymentController {
	private final PaymentService paymentService;

	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(
		@PathVariable(name = "workerId") UUID workerId,
		@PathVariable(name = "days") Integer days) {

		return ResponseEntity.ok(paymentService.getPayment(workerId, days));
	}
}
