package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public interface AdminService {
	public boolean  registerAdminAccount(com.example.demo.dto.Admin admin);
	
	public boolean userNameNotExists(String userName);
	
	public boolean emailNotExists(String email);
	
	public boolean phoneNumberNotExists(String phoneNumber);
	
	public boolean cccdNotExists(String cccd);
}
