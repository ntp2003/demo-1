package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StockDetails;

@Repository
public interface StockDetailsRepo extends JpaRepository<StockDetails, Integer>, QuerydslPredicateExecutor<StockDetails>{

}