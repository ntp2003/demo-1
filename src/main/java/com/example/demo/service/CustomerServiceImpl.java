package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.CustomerAccount;
import com.example.demo.model.LoginHistory;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.repository.LoginHistoryRepo;
import com.example.demo.security.userdetails.CustomerUserDetails;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	@Qualifier("customerPasswordEncoder")
	private PasswordEncoder customerPasswordEncoder;
	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private LoginHistoryRepo loginHistoryRepo;

	@Override
	public com.example.demo.dto.CustomerAccount registerCustomerAccount(
			com.example.demo.dto.CustomerAccount customerAccount) throws Exception {
		if (emailNotExists(customerAccount.getEmail())) {
			CustomerAccount newCustomer = customerAccount.toModel();
			newCustomer.setPassword(customerPasswordEncoder.encode(customerAccount.getPassword()));
			return new com.example.demo.dto.CustomerAccount(customerRepo.save(newCustomer));
		}
		throw new Exception("Email already exists!");
	}

	@Override
	public boolean emailNotExists(String email) {
		return !customerRepo.existsCustomerAccountByEmail(email);
	}

	@Override
	public void recordSuccessLog() throws Exception{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			CustomerUserDetails customerUserDetails = (CustomerUserDetails) authentication.getPrincipal();
			LoginHistory dataHistory = new LoginHistory();
			dataHistory.setCustomerAccount(customerUserDetails.getCustomerAccount().toModel());
			dataHistory.setStatus("Success");
			dataHistory.setLoginTime(LocalDateTime.now());
			loginHistoryRepo.save(dataHistory);
		}
		else {
			throw new Exception("Not have user information");
		}
	}
}
