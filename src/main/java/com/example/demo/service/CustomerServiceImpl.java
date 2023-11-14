package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.CustomerAccount;
import com.example.demo.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private PasswordEncoder customerPasswordEncoder;
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public com.example.demo.dto.CustomerAccount validateLoginInfo(String email, String password) throws Exception, UsernameNotFoundException {
		Optional<CustomerAccount> customerOptional = customerRepo.findOptionalByEmail(email);
		
		if(customerOptional.isPresent()) {
			CustomerAccount customer = customerOptional.get();
			
			if(customer.getPassword().equals(password)) {
				return new com.example.demo.dto.CustomerAccount(customer);
			}
			
			throw new Exception("Password is not correctly!");
		}
		else {
			throw new UsernameNotFoundException("Email is not exists!");
		}
	}

	@Override
	public com.example.demo.dto.CustomerAccount registerCustomerAccount(com.example.demo.dto.CustomerAccount customerAccount) throws Exception {
		if(customerRepo.existsCustomerAccountByEmail(customerAccount.getEmail()))
		{
			throw new Exception("Email already exists!");
		}
		CustomerAccount newCustomer = customerAccount.toModel();
		newCustomer.setPassword(customerPasswordEncoder.encode(customerAccount.getPassword()));
		return new com.example.demo.dto.CustomerAccount(customerRepo.save(newCustomer));
	}
}
