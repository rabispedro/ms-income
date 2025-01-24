package com.brcme.worker.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brcme.worker.api.entities.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, UUID> {
	
}
