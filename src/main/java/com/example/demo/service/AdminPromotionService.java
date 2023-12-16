package com.example.demo.service;

import java.util.Map.Entry;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Promotion;
import com.example.demo.dto.PromotionFilter;

@Service
public interface AdminPromotionService {
	public Entry<Short, String> findProductCatalog(short productId);
	
	public boolean addPromotion(Promotion promotion);
	
	public boolean deletePromotion(int promotionId);
	
	public Page<Promotion> getPromotionPage(PromotionFilter filter, Pageable pageable);
}
