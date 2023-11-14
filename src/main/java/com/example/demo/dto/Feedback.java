// Generated with g9.

package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Feedback implements Serializable {
    private String review;
    private LocalDateTime time;
    private short rating;
    private CustomerAccount customerAccount;
    private PurchaseInvoice purchaseInvoice;
    private ProductCategory productCategory;
}
