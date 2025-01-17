package com.brcme.worker.worker.dtos.worker;

import java.math.BigInteger;
import java.util.UUID;

public record WorkerResponseDto(
	UUID id,
	String name,
	BigInteger dailyIncome) {}
