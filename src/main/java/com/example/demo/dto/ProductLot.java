package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductLot implements Serializable {
    private int lotId;
    private LocalDate importDate;
    private String confirmerName;
    private String confirmerPhoneNumber;
    private String confirmerEmail;
    
    public ProductLot(com.example.demo.model.ProductLot productLot) {
    	this.lotId = productLot.getLotId();
    	this.importDate = productLot.getImportDate();
    	this.confirmerName = productLot.getAdmin().getFullName();
    	this.confirmerPhoneNumber = productLot.getAdmin().getPhoneNumber();
    	this.confirmerEmail = productLot.getAdmin().getEmail();
    }
}
