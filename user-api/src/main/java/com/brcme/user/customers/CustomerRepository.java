package com.brcme.user.customers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID>{
	@Query(
		nativeQuery = true,
		value = "SELECT c FROM \"Customer\" c WHERE c.email ILIKE :email")
		Optional<Customer> findByEmail(@Param("email") String email);
}
