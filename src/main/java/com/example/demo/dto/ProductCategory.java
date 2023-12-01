// Generated with g9.

package com.example.demo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.example.demo.model.ProductCatalog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory implements Serializable {
    private int productCategoryId;
    private String color;
    private BigDecimal price;
    private short productId;
    
    public ProductCategory(com.example.demo.model.ProductCategory productCategory) {
    	this.productCategoryId = productCategory.getProductCategoryId();
    	this.color = productCategory.getColor();
    	this.price = productCategory.getPrice();
    	this.productId = productCategory.getProductCatalog().getProductId();
    }
    
    public com.example.demo.model.ProductCategory toModel(){
    	com.example.demo.model.ProductCategory pCategory = new  com.example.demo.model.ProductCategory();
    	
    	pCategory.setProductCategoryId(productCategoryId);
    	pCategory.setColor(color);
    	pCategory.setPrice(price);
    	ProductCatalog pCatalog = new ProductCatalog();
    	pCatalog.setProductId(productId);
    	pCategory.setProductCatalog(pCatalog);
    	
    	return pCategory;
    }
}
