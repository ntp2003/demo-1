package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Admin;
import com.example.demo.repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	@Qualifier("adminPasswordEncoder")
	PasswordEncoder adminPasswordEncoder;
	
	@Autowired
	AdminRepo adminRepo;
	
	@Override
	public boolean registerAdminAccount(Admin admin){
		try {
			adminRepo.save(admin.toModel());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean emailNotExists(String email) {
		return !adminRepo.existsAdminByEmail(email);
	}

	@Override
	public boolean phoneNumberNotExists(String phoneNumber) {
		return !adminRepo.existsAdminByPhoneNumber(phoneNumber);
	}

	@Override
	public boolean cccdNotExists(String cccd) {
		return !adminRepo.existsAdminByCccd(cccd);
	}

	@Override
	public boolean userNameNotExists(String userName) {
		return !adminRepo.existsById(userName);
	}
	
}
