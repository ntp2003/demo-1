package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountFilter;
import com.example.demo.dto.Admin;
import com.example.demo.dto.CustomerAccount;
import com.example.demo.model.QAdmin;
import com.example.demo.model.QCustomerAccount;
import com.example.demo.repository.AdminRepo;
import com.example.demo.repository.CustomerRepo;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

@Service
public class AdminAccountManagementServiceImpl implements AdminAccountManagementService {
	@Autowired
	AdminRepo adminRepo;
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Override
	public Page<Admin> findAdminAccount(AccountFilter accountFilter, Pageable pageable) {
		QAdmin qAdmin = QAdmin.admin;
		BooleanExpression predicate = Expressions.asBoolean(true).isTrue();

		switch (accountFilter.getSearchOption()) {
		case NAME:
			predicate = qAdmin.fullName.contains(accountFilter.getSearchValue());
			break;
		case PHONENUMBER:
			predicate = qAdmin.phoneNumber.startsWith(accountFilter.getSearchValue());
			break;
		case EMAIL:
			predicate = qAdmin.email.startsWith(accountFilter.getSearchValue());
			break;
		case CCCD:
			predicate = qAdmin.cccd.startsWith(accountFilter.getSearchValue());
			break;
		case USERNAME:
			predicate = qAdmin.username.startsWith(accountFilter.getSearchValue());
			break;
		default:
			throw new IllegalStateException("Unknown argument value !!!");
		}

		return adminRepo.findAll(predicate, pageable).map(Admin::new);
	}

	@Override
	public Page<CustomerAccount> findCustomerAccount(AccountFilter accountFilter, Pageable pageable) {
		QCustomerAccount qCustomerAccount = QCustomerAccount.customerAccount;
		BooleanExpression predicate = Expressions.asBoolean(true).isTrue();

		switch (accountFilter.getSearchOption()) {
		case NAME:
			predicate = qCustomerAccount.customerName.contains(accountFilter.getSearchValue());
			break;
		case PHONENUMBER:
			predicate = qCustomerAccount.phoneNumber.startsWith(accountFilter.getSearchValue());
			break;
		case EMAIL:
			predicate = qCustomerAccount.email.startsWith(accountFilter.getSearchValue());
			break;
		default:
			throw new IllegalStateException("Unknown argument value !!!");
		}

		return customerRepo.findAll(predicate, pageable).map(CustomerAccount::new);
	}

	@Override
	public boolean deleteAdminAccount(String userName) {
		try {
			adminRepo.deleteById(userName);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCustomerAccount(int accountId) {
		try {
			customerRepo.deleteById(accountId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
