package com.brcme.payroll.api.repositories;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.brcme.payroll.api.entities.Worker;

@FeignClient(name = "worker-api", url = "localhost:8840", path = "/workers")
@Component
public interface WorkerRepository {
	@GetMapping
	ResponseEntity<Page<Worker>> getAll(Pageable page);

	@GetMapping("/{id}")
	ResponseEntity<Worker> getById(@PathVariable("id") UUID id);
}
