package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PromotionDetail;
import com.example.demo.model.IdClass.PromotionDetailId;

@Repository
public interface PromotionDetailRepo extends JpaRepository<PromotionDetail, PromotionDetailId>{

}
