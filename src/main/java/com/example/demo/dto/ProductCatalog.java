// Generated with g9.

package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCatalog implements Serializable {
    private short productId;
    private LocalDate releaseDate;
    private String productName;
    private String origin;
    private String brand;
    private int purchaseCount = 0;
    private String description;
    private ProductType productType;
    
    public ProductCatalog(com.example.demo.model.ProductCatalog productCatalog) {
    	this.productId = productCatalog.getProductId();
    	this.releaseDate = productCatalog.getReleaseDate();
    	this.productName = productCatalog.getProductName();
    	this.origin = productCatalog.getOrigin();
    	this.brand = productCatalog.getBrand();
    	this.purchaseCount = productCatalog.getPurchaseCount();
    	this.description = productCatalog.getDescription();
    	this.productType = new ProductType(productCatalog.getProductType());
    }
    
    public com.example.demo.model.ProductCatalog toModel(){
    	com.example.demo.model.ProductCatalog pCatalog = new com.example.demo.model.ProductCatalog();
    	
    	pCatalog.setProductId(productId);
    	pCatalog.setReleaseDate(releaseDate);
    	pCatalog.setProductName(productName);
    	pCatalog.setOrigin(origin);
    	pCatalog.setBrand(brand);
    	pCatalog.setPurchaseCount(purchaseCount);
    	pCatalog.setDescription(description);
    	pCatalog.setProductType(productType.toModel());
    	
    	return pCatalog;
    }
}
