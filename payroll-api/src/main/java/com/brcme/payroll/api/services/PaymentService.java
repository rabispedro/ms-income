package com.brcme.payroll.api.services;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.brcme.payroll.api.entities.Payment;
import com.brcme.payroll.api.entities.Worker;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class PaymentService {
	@Value("${worker-api.host}")
	private String workerApiHost;

	private final RestTemplate workerApiRestTemplate;

	public Payment getPayment(UUID workerId, Integer days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", workerId.toString());
		
		Worker worker = workerApiRestTemplate
		.getForObject(workerApiHost + "/workers/{id}", Worker.class, uriVariables);
		log.info("WorkerAPI Response {}", worker);
		
		return Payment
			.builder()
			.name(worker.getName())
			.dailyIncome(worker.getDailyIncome())
			.days(days)
			.build();
	}
}
