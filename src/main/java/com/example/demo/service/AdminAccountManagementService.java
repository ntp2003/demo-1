package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountFilter;
import com.example.demo.dto.Admin;
import com.example.demo.dto.CustomerAccount;

@Service
public interface AdminAccountManagementService {
	public Page<Admin> findAdminAccount(AccountFilter accountFilter, Pageable pageable);
	
	public Page<CustomerAccount> findCustomerAccount(AccountFilter accountFilter, Pageable pageable);
	
	public boolean deleteAdminAccount(String userName);
	
	public boolean deleteCustomerAccount(int accountId);
}
