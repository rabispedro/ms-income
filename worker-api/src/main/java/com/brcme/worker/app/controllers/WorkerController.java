package com.brcme.worker.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brcme.worker.app.dtos.responses.WorkerResponseDto;
import com.brcme.worker.core.ports.services.WorkerServicePort;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/workers")
public class WorkerController {
	private final WorkerServicePort workerService;

	@Value("${eureka.instance.instance-id}")
	private String eurekaInstanceId;

	@GetMapping
	public ResponseEntity<List<WorkerResponseDto>> getAll() {
		return ResponseEntity.ok(workerService.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<WorkerResponseDto> getById(
		@Parameter(name = "id") @PathVariable("id") UUID id) {

		return ResponseEntity.ok(workerService.getById(id));
	}

	@GetMapping("/config")
	public ResponseEntity<Void> getConfig() {
		log.info("Eureka Instance Id: {}", eurekaInstanceId);
		return ResponseEntity.noContent().build();
	}
}
