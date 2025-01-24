package com.brcme.payroll.api.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Worker implements Serializable {
	private UUID id;
	private String name;
	private BigInteger dailyIncome;
}
