package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Promotion;
import com.example.demo.model.PromotionDetail;

@Repository
public interface PromotionRepo extends JpaRepository<Promotion, Integer> , QuerydslPredicateExecutor<Promotion>{

}
