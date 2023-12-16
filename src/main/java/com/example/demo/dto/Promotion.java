package com.example.demo.dto;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.example.demo.util.Converter;
import com.example.demo.util.FirebaseUtil;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Promotion implements Serializable {
    private int promotionId;
    private String promotionName;
    private LocalDate startTime;
    private LocalDate endTime;
    private String banner;
    private boolean canDelete;
    private List<PromotionItem> items;
    
    public Promotion(com.example.demo.model.Promotion promotion) {
    	promotionId = promotion.getPromotionId();
    	promotionName = promotion.getPromotionName();
    	startTime = promotion.getStartTime();
    	endTime = promotion.getEndTime();
    	banner = promotion.getBanner();
    	canDelete = promotion.getStartTime().isAfter(LocalDate.now());
    	
    	items = promotion.getPromotionDetail().stream().map(i -> PromotionItem.builder()
    			.productId(i.getPromotionDetailId().getProductCatalog().getProductId())
    			.productName(i.getPromotionDetailId().getProductCatalog().getProductName())
    			.discountRate(i.getDiscountRate()).build()).toList();
    }
    
    public com.example.demo.model.Promotion toModel() throws IOException{
    	com.example.demo.model.Promotion model = new com.example.demo.model.Promotion();
    	
    	model.setPromotionName(promotionName);
    	model.setStartTime(startTime);
    	model.setEndTime(endTime);
    	model.setBanner(FirebaseUtil.Upload(Converter.DataURLImagetoFile(banner)));
    	
    	return model;
    }
}
