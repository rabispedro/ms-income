package com.brcme.user.roles;

import java.util.Set;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brcme.user.roles.dtos.RoleListResponseDto;
import com.brcme.user.roles.dtos.RoleResponseDto;
import com.brcme.user.roles.usecases.IFindRoleById;
import com.brcme.user.roles.usecases.IFindAllRolesByName;
import com.brcme.user.roles.usecases.IFindAllRolesByUserId;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/roles")
public class RoleController {
	private final IFindRoleById findRoleById;
	private final IFindAllRolesByUserId findAllRolesByUserId;
	private final IFindAllRolesByName findAllRolesByName;

	@GetMapping("/{id}")
	public ResponseEntity<RoleResponseDto> getById(
		@PathVariable("id") UUID id) {

		return ResponseEntity.ok(findRoleById.execute(id));
	}

	@GetMapping("/search")
	public ResponseEntity<RoleListResponseDto> getAllByName(
		@RequestParam("names") Set<String> names) {

		return ResponseEntity.ok(findAllRolesByName.execute(names));
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<RoleListResponseDto> getAllByUserId(
		@PathVariable("userId") UUID userId) {

		return ResponseEntity.ok(findAllRolesByUserId.execute(userId));
	}
}
