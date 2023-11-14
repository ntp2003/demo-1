// Generated with g9.

package com.example.demo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class PurchaseInvoice implements Serializable {
    private int invoiceId;
    private LocalDateTime createdTime;
    private String address;
    private String phoneNumber;
    private BigDecimal originalPrice;
    private BigDecimal discount;
    private BigDecimal shippingFee;
    private BigDecimal total;
    private LocalDateTime completedTime;
    private Payment payment;
}
