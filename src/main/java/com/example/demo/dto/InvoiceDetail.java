// Generated with g9.

package com.example.demo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class InvoiceDetail implements Serializable {
    private int quantity;
    private BigDecimal originalPrice;
    private BigDecimal discount;
    private PurchaseInvoice purchaseInvoice;
    private ProductCategory productCategory;
}
