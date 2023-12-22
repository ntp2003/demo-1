package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ProductCatalog;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.sql.JPASQLQuery;

@Repository
public interface ProductCatalogRepo extends JpaRepository<ProductCatalog, Short> , QuerydslPredicateExecutor<ProductCatalog>{
	
	Page<ProductCatalog> findByProductNameContaining(String containing, Pageable pageable);
	
	@Query("SELECT DISTINCT p.brand FROM ProductCatalog p")
	List<String> findDistinctBrand();
}
