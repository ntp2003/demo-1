package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, String>, QuerydslPredicateExecutor<Admin>{
	Optional<Admin> findOptionalByUsername(String username);
	
	boolean existsAdminByPhoneNumber(String phoneNumber);
	
	boolean existsAdminByEmail(String email);
	
	boolean existsAdminByCccd(String cccd);
}
