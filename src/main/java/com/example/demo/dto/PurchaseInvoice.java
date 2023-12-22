// Generated with g9.

package com.example.demo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.demo.model.PurchaseHistory;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PurchaseInvoice implements Serializable {
    private int invoiceId;
    private LocalDateTime createdTime;
    private int purchaseHistoryId;
    private int accountId;
    private String status;
    private BigDecimal total;
    private LocalDateTime completedTime;
    private String payment;
    private List<String> nextPossibleStatus;
    
    public PurchaseInvoice(com.example.demo.model.PurchaseInvoice p) {
    	PurchaseHistory purchaseHistory = p.getPurchaseHistory().stream().findFirst().get();
    	invoiceId = p.getInvoiceId();
    	createdTime = p.getCreatedTime();
    	purchaseHistoryId = purchaseHistory.getPurchaseId();
    	accountId = purchaseHistory.getCustomerAccount().getAccountId();
    	status = purchaseHistory.getStatus();
    	total = p.getTotal();
    	completedTime = p.getCompletedTime();
    	payment = p.getPayment().getDescription();
    	nextPossibleStatus = InvoiceStatus.nextPossibleStatus(status);
    }
}
