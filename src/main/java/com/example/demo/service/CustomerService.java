package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.CustomerAccount;

@Service
public interface CustomerService {
	public CustomerAccount validateLoginInfo(String email, String password) throws Exception;
	
	public CustomerAccount  registerCustomerAccount(CustomerAccount customerAccount) throws Exception;
}
