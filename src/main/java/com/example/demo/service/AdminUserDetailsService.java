package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepo;
import com.example.demo.security.userdetails.AdminUserDetails;

public class AdminUserDetailsService implements UserDetailsService{
	@Autowired
	private AdminRepo adminRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Admin> admin = adminRepo.findOptionalByUsername(username);
		return admin.map(AdminUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("user not found: " + username));
	}
}
