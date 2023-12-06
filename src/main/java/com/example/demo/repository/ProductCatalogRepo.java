package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ProductCatalog;

@Repository
public interface ProductCatalogRepo extends JpaRepository<ProductCatalog, Short> , QuerydslPredicateExecutor<ProductCatalog>{
	Page<ProductCatalog> findByProductNameContaining(String containing, Pageable pageable);
}
