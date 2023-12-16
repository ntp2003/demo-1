package com.example.demo.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Promotion;
import com.example.demo.dto.PromotionFilter;
import com.example.demo.model.ProductCatalog;
import com.example.demo.model.PromotionDetail;
import com.example.demo.model.QPromotion;
import com.example.demo.model.IdClass.PromotionDetailId;
import com.example.demo.repository.ProductCatalogRepo;
import com.example.demo.repository.PromotionDetailRepo;
import com.example.demo.repository.PromotionRepo;
import com.example.demo.util.FirebaseUtil;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

@Service
public class AdminPromotionServiceImpl implements AdminPromotionService{
	@Autowired
	ProductCatalogRepo productCatalogRepo;
	
	@Autowired
	PromotionRepo promotionRepo;
	
	@Autowired
	PromotionDetailRepo promotionDetailRepo;
	
	@Override
	public Entry<Short, String> findProductCatalog(short productId) {
		return productCatalogRepo.findById(productId).map(i -> (Entry<Short, String>)(new AbstractMap.SimpleEntry<Short, String>(i.getProductId(), i.getProductName())))
				.orElseThrow(() -> new NotFoundException("Product catalog not found"));
	}

	@Override
	public boolean addPromotion(Promotion promotion) {
		com.example.demo.model.Promotion promotionModel;
		try {
			promotionModel = promotionRepo.save(promotion.toModel());
		} catch (IllegalArgumentException  e) {
			System.out.println("Tham số không hợp lệ");
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		promotion.getItems().forEach((i) ->{
			PromotionDetail promotionDetail = new PromotionDetail();
			promotionDetail.setPromotionDetailId(new PromotionDetailId());
			promotionDetail.setDiscountRate(i.getDiscountRate());
			promotionDetail.getPromotionDetailId().setProductCatalog(new ProductCatalog(i.getProductId()));
			promotionDetail.getPromotionDetailId().setPromotion(promotionModel);
			promotionDetailRepo.save(promotionDetail);
		});
		
		return true;
	}

	@Override
	public boolean deletePromotion(int promotionId) {
		return promotionRepo.findById(promotionId).map(i -> {
			if(canDelete(i.getStartTime())) {
				promotionRepo.delete(i);
				try {
					FirebaseUtil.Delete(i.getBanner());
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}
			return false;
		}).orElse(false);
	}

	@Override
	public Page<Promotion> getPromotionPage(PromotionFilter filter, Pageable pageable) {
		QPromotion qPromotion = QPromotion.promotion;
		BooleanExpression predicate = Expressions.asBoolean(true).isTrue();
		if(filter.getFromDay() != null)
			predicate = predicate.and(qPromotion.startTime.goe(filter.getFromDay()));
		if(filter.getToDay() != null)
			predicate = predicate.and(qPromotion.endTime.loe(filter.getToDay()));
		if(filter.getSearchValue() != null || filter.getSearchValue().isBlank())
			predicate = predicate.and(qPromotion.promotionName.contains(filter.getSearchValue()));
		
		return promotionRepo.findAll(predicate, pageable).map(i -> new Promotion(i));
	}
	
	private boolean canDelete(LocalDate startTime) {
		return startTime.isAfter(LocalDate.now());
	}
}
