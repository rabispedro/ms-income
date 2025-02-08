package com.brcme.worker.core.ports.services;

import java.util.List;
import java.util.UUID;

import com.brcme.worker.app.dtos.responses.WorkerResponseDto;

public interface WorkerServicePort {
	List<WorkerResponseDto> getAll();
	WorkerResponseDto getById(UUID id);
}
