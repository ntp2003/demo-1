package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Admin;

@Service
public class AdminServiceImpl implements AdminService{

	@Override
	public Admin registerAdminAccount(Admin admin) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean emailNotExists(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean phoneNumberNotExists(String phoneNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cccdNotExists(String cccd) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
