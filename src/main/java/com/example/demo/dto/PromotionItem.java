package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PromotionItem {
	short productId;
	String productName;
	short discountRate;
}
