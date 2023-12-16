package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.PromotionDetail;
import com.example.demo.model.IdClass.PromotionDetailId;

public interface PromotionDetailRepo extends JpaRepository<PromotionDetail, PromotionDetailId>{

}
