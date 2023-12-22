package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PurchaseInvoice;

@Repository
public interface PurchaseInvoiceRepo extends JpaRepository<PurchaseInvoice, Integer>, QuerydslPredicateExecutor<PurchaseInvoice>{

}
