package com.brcme.payroll.api.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.brcme.payroll.api.entities.Payment;
import com.brcme.payroll.api.entities.Worker;
import com.brcme.payroll.api.repositories.WorkerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class PaymentService {
	private final WorkerRepository workerRepository;

	public Payment getPayment(UUID workerId, Integer days) {
		Worker worker = workerRepository.getById(workerId).getBody();
		log.info("WorkerAPI Response {}", worker);
		
		return Payment
			.builder()
			.name(worker.getName())
			.dailyIncome(worker.getDailyIncome())
			.days(days)
			.build();
	}
}
