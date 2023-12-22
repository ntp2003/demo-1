package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ProductCatalog;
import com.example.demo.model.ProductCategory;

@Repository
public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Integer>, QuerydslPredicateExecutor<ProductCategory>{
	List<ProductCategory> findByProductCatalog(ProductCatalog productCatalog);
	
	@Query("SELECT DISTINCT t.color FROM ProductCategory t")
	List<String> findDistinctColor();
}
