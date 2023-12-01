package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ProductCatalog;

@Repository
public interface ProductCatalogRepo extends JpaRepository<ProductCatalog, Short>{
}
