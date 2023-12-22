package com.example.demo.dto;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.model.Promotion;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PromotionSimple {
	private int promotionId;
    private String promotionName;
    private LocalDate startTime;
    private LocalDate endTime;
    private String banner;
    
    public PromotionSimple(Promotion promotion) {
    	promotionId = promotion.getPromotionId();
    	promotionName = promotion.getPromotionName();
    	startTime = promotion.getStartTime();
    	endTime = promotion.getEndTime();
    	banner = promotion.getBanner();
    }
}
