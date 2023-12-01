package com.example.demo.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ProductType;
import com.example.demo.model.Size;

public interface SizeRepo extends JpaRepository<Size, Short>{
	Set<SizeId> findByProductType(ProductType productType);
	
	public interface SizeId {
		short getSizeId();
	}
}
