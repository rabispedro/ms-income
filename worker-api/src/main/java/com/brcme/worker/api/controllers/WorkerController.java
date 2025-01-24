package com.brcme.worker.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brcme.worker.api.dtos.worker.WorkerResponseDto;
import com.brcme.worker.api.services.WorkerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.UUID;

import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/workers")
public class WorkerController {
	private final Environment env;
	private final WorkerService workerService;

	@GetMapping
	public ResponseEntity<Page<WorkerResponseDto>> getAll(Pageable page) {
		log.info("Port: {}", env.getProperty("local.server.port"));
		return ResponseEntity.ok(workerService.getAll(page));
	}

	@GetMapping("/{id}")
	public ResponseEntity<WorkerResponseDto> getById(@PathVariable("id") UUID id) {
		return ResponseEntity.ok(workerService.getById(id));
	}
}
