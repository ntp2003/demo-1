package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.CustomerAccount;

@Service
public interface CustomerService {
	public com.example.demo.dto.CustomerAccount  registerCustomerAccount(com.example.demo.dto.CustomerAccount customerAccount) throws Exception;
	
	public boolean emailNotExists(String email);
	
	public void recordSuccessLog() throws Exception;
}
