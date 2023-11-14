package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.model.CustomerAccount;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.security.userdetails.CustomerUserDetails;

public class CustomerUserDetailsService implements UserDetailsService{
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<CustomerAccount> customerAccount = customerRepo.findOptionalByEmail(username);
		return customerAccount.map(CustomerUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("No user found with the given email"));
	}

}
