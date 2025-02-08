package com.brcme.worker.core.ports.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.Repository;

import com.brcme.worker.core.entities.Worker;

public interface WorkerRepositoryPort extends Repository<Worker, UUID> {
	abstract List<Worker> findAll();
	abstract Optional<Worker> findById(UUID id);
}
