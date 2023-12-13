package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ProductLot;

@Repository
public interface ProductLotRepo extends JpaRepository<ProductLot, Integer>, QuerydslPredicateExecutor<ProductLot> {

}
