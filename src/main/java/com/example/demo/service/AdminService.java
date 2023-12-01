package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public interface AdminService {
	public com.example.demo.dto.Admin  registerAdminAccount(com.example.demo.dto.Admin admin) throws Exception;
	
	public boolean emailNotExists(String email);
	
	public boolean phoneNumberNotExists(String phoneNumber);
	
	public boolean cccdNotExists(String cccd);
}
