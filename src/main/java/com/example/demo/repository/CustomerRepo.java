package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.model.*;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerAccount, Integer>, QuerydslPredicateExecutor<CustomerAccount>{
	Optional<CustomerAccount> findOptionalByEmail(String email);
	
	boolean existsCustomerAccountByEmail(String email);
}
