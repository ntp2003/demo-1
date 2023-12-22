package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.InvoiceDetail;
import com.example.demo.model.IdClass.InvoiceDetailId;

@Repository
public interface InvoiceDetailRepo extends JpaRepository<InvoiceDetail, InvoiceDetailId>{
	
}
