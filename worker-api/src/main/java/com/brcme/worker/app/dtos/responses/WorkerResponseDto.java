package com.brcme.worker.app.dtos.responses;

import java.math.BigInteger;
import java.util.UUID;

public record WorkerResponseDto(
	UUID id,
	String name,
	BigInteger dailyIncome) {}
