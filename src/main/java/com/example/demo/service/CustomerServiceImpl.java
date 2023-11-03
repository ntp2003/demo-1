package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CustomerAccount;
import com.example.demo.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public CustomerAccount validateLoginInfo(String email, String password) throws Exception {
		Optional<CustomerAccount> customerOptional = customerRepo.findOptionalByEmail(email);
		
		if(customerOptional.isPresent()) {
			CustomerAccount customer = customerOptional.get();
			
			if(customer.getPassword().equals(password)) {
				return customer;
			}
			
			throw new Exception("Password is not correctly!");
		}
		else {
			throw new Exception("Email is not exists!");
		}
	}

	@Override
	public CustomerAccount registerCustomerAccount(CustomerAccount customerAccount) throws Exception {
		if(customerRepo.existsCustomerAccountByEmail(customerAccount.getEmail()))
		{
			throw new Exception("Email already exists!");
		}
		return customerRepo.save(customerAccount);
	}
}
