package com.brcme.worker.worker.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Worker")
public class Worker implements Serializable {
	@Id
	@GeneratedValue
	private UUID id;

	@Column(name = "name")
	private String name;

	@Column(name = "daily_income")
	private BigInteger dailyIncome;
}
