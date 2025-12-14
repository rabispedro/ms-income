package com.brcme.worker.core.adapters.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.brcme.worker.app.dtos.responses.WorkerResponseDto;
import com.brcme.worker.core.entities.Worker;
import com.brcme.worker.core.ports.repositories.WorkerRepositoryPort;
import com.brcme.worker.core.ports.services.WorkerServicePort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class WorkerServiceAdapter implements WorkerServicePort {
	private final WorkerRepositoryPort workerRepository;

	public List<WorkerResponseDto> getAll() {
		return workerRepository
			.findAll()
			.stream()
			.map(worker -> new WorkerResponseDto(worker.getId(), worker.getName(), worker.getDailyIncome()))
			.toList();
	}

	public WorkerResponseDto getById(UUID id) {
		Worker worker = workerRepository
			.findById(id)
			.orElseThrow(() -> new RuntimeException("Worker not found"));
		
		return new WorkerResponseDto(id, worker.getName(), worker.getDailyIncome());
	}
}
