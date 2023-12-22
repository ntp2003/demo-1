package com.example.demo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.PurchaseHistory;
import com.example.demo.model.PurchaseInvoice;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderView implements Serializable{
	private int invoiceId;
    private LocalDateTime createdTime;
    private int purchaseHistoryId;
    private int accountId;
    private String status;
    private BigDecimal total;
    private LocalDateTime completedTime;
    private String payment; 
    private List<OrderItem> orderItems;
    
    public OrderView(PurchaseHistory purchaseHistory) {
    	PurchaseInvoice p = purchaseHistory.getPurchaseInvoice();
    	invoiceId = p.getInvoiceId();
    	createdTime = p.getCreatedTime();
    	purchaseHistoryId = purchaseHistory.getPurchaseId();
    	accountId = purchaseHistory.getCustomerAccount().getAccountId();
    	status = purchaseHistory.getStatus();
    	total = p.getTotal();
    	completedTime = p.getCompletedTime();
    	payment = p.getPayment().getDescription();
    	orderItems = new ArrayList<>();
    	p.getInvoiceDetail().forEach(i -> {
    		OrderItem orderItem = new OrderItem(i);
    		orderItem.setCanFeedback(purchaseHistory.getFeedback().stream().filter(f -> f.getFeedbackId().getStockDetails()
    				.getStockInventoryId() == orderItem.getStockInventoryId()).count() == 0 && purchaseHistory.getStatus().equals(InvoiceStatus.COMPLETED));
    		orderItems.add(orderItem);
     	});
    }
}
