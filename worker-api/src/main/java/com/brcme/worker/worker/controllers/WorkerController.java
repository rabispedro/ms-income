package com.brcme.worker.worker.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brcme.worker.worker.dtos.worker.WorkerResponseDto;
import com.brcme.worker.worker.services.WorkerService;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@RestController
@RequestMapping("/workers")
public class WorkerController {
	private final WorkerService workerService;

	@GetMapping("")
	public ResponseEntity<Page<WorkerResponseDto>> getAll(Pageable page) {
		return ResponseEntity.ok(workerService.getAll(page));
	}

	@GetMapping("/{id}")
	public ResponseEntity<WorkerResponseDto> getById(@PathVariable("id") UUID id) {
		return ResponseEntity.ok(workerService.getById(id));
	}
}
