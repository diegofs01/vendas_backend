package com.diego.venda.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.diego.venda.model.JwtUserDetails;

public interface JwtUserRepository extends CrudRepository<JwtUserDetails, String> {
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE user SET email = ?1, role = ?2 WHERE username = ?3")
	void updateUser(String email, String role, String username);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE user SET password = ?1 WHERE username = ?2")
	void updatePassword(String password, String username);
}
