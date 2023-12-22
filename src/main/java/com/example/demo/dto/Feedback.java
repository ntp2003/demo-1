package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import com.example.demo.model.PurchaseHistory;
import com.example.demo.model.StockDetails;
import com.example.demo.model.IdClass.FeedbackId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Feedback implements Serializable {
	private int purchaseHistoryId;
	private int stockInventoryId;
    private String review;
    private LocalDateTime time;
    private short rating;
    
    public com.example.demo.model.Feedback toModel(){
    	com.example.demo.model.Feedback feedback = new com.example.demo.model.Feedback();
    	StockDetails stockDetails = new StockDetails();
    	PurchaseHistory purchaseHistory = new PurchaseHistory();
    	
    	stockDetails.setStockInventoryId(stockInventoryId);
    	purchaseHistory.setPurchaseId(purchaseHistoryId);
    	feedback.setFeedbackId(new FeedbackId());
    	feedback.getFeedbackId().setPurchaseHistory(purchaseHistory);
    	feedback.getFeedbackId().setStockDetails(stockDetails);
    	feedback.setReview(review);
    	feedback.setRating(rating);
    	feedback.setTime(LocalDateTime.now());
    	
    	return feedback;
    }
}
