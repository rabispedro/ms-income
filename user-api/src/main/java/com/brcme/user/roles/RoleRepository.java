package com.brcme.user.roles;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
	@Query(
		nativeQuery = true,
		value = "SELECT r FROM \"Role\" r INNER JOIN \"Customer_Role\" cr ON r.id = cr.role_id WHERE cr.user_id ILIKE :userId")
	Set<Role> findAllByUserId(@Param("userId") UUID userId);

	@Query(
		nativeQuery = true,
		value = "SELECT r FROM \"Role\" r WHERE r.name = :names")
	Set<Role> findAllByName(@Param("names") Set<String> names);
}
