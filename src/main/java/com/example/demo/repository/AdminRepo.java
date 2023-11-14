package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, String>{
	Optional<Admin> findOptionalByUsername(String username);
}
