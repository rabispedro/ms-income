package com.brcme.payroll.api.entities;

import java.io.Serializable;
import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment implements Serializable {
	private String name;
	private BigInteger dailyIncome;
	private Integer days;

	public BigInteger getTotal() {
		return dailyIncome.multiply(BigInteger.valueOf(days));
	}
}