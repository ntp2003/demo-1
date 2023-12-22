package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.example.demo.model.Feedback;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDetailFeedBack implements Serializable{
	String customerName;
	String avatar;
	short rate;
	String review;
	LocalDateTime time;
	String color;
	String size;
	
	public ProductDetailFeedBack(Feedback feedback) {
		rate = feedback.getRating();
		review = feedback.getReview();
		time = feedback.getTime();
		color = feedback.getFeedbackId().getStockDetails().getProductCategory().getColor();
		size = feedback.getFeedbackId().getStockDetails().getSize().getSizeName();
		customerName = feedback.getFeedbackId().getPurchaseHistory().getCustomerAccount().getCustomerName();
		avatar = feedback.getFeedbackId().getPurchaseHistory().getCustomerAccount().getAvatar();
	}
}
