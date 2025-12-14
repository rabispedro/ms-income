package com.brcme.user.customers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID>{
	@NativeQuery("""
		SELECT
			c.id,
			c.email,
			c.name,
			c.password,
			cr.customer_id,
			r.id AS role_id,
			r.name AS role_name
		FROM customer c
		LEFT JOIN customer_role cr ON c.id = cr.customer_id
		LEFT JOIN role r ON r.id = cr.role_id
		WHERE c.email = :email
		""")
		Optional<Customer> findByEmail(@Param("email") String email);
}
