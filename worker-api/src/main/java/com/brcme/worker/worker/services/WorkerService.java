package com.brcme.worker.worker.services;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.brcme.worker.worker.dtos.worker.WorkerResponseDto;
import com.brcme.worker.worker.entities.Worker;
import com.brcme.worker.worker.repositories.WorkerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class WorkerService {
	private final WorkerRepository workerRepository;

	public Page<WorkerResponseDto> getAll(Pageable page) {
		return workerRepository
			.findAll(page)
			.map(worker -> new WorkerResponseDto(worker.getId(), worker.getName(), worker.getDailyIncome()));
	}

	public WorkerResponseDto getById(UUID id) {
		Worker worker = workerRepository
			.findById(id)
			.orElseThrow(() -> new RuntimeException("Worker not found"));
		
		return new WorkerResponseDto(id, worker.getName(), worker.getDailyIncome());
	}
}
