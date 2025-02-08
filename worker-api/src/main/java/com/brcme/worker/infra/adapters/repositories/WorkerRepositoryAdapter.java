package com.brcme.worker.infra.adapters.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.brcme.worker.core.entities.Worker;
import com.brcme.worker.core.ports.repositories.WorkerRepositoryPort;

@Primary
@Repository
public interface WorkerRepositoryAdapter extends WorkerRepositoryPort {
	@Override
	@Query(nativeQuery = true,
	value = "SELECT id, name, daily_income FROM worker")
	List<Worker> findAll();
	
	@Override
	@Query(nativeQuery = true,
	value = "SELECT id, name, daily_income FROM WORKER WHERE :id = id")
	Optional<Worker> findById(@Param("id") UUID id);
}
