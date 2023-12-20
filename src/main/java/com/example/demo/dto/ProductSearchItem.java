package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.model.ProductCatalog;
import com.example.demo.model.Promotion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductSearchItem implements Serializable{
	private short productId;
    private String productName;
    private int purchaseCount;
    private short discountRate;
    private String image;
    
    public ProductSearchItem(ProductCatalog productCatalog) {
    	productId = productCatalog.getProductId();
    	productName = productCatalog.getProductName();
    	purchaseCount = productCatalog.getPurchaseCount();
    	productCatalog.getProductCategory().forEach(i -> {
    		if(!i.getImageProduct().isEmpty()) {
    			image = i.getImageProduct().stream().findFirst().get().getImage();
    			return;
    		}
    	});
    }
    
    public ProductSearchItem(ProductCatalog productCatalog, Promotion promotion) {
    	this(productCatalog);
    	promotion.getPromotionDetail().forEach( i -> {
    		if(this.productId == i.getPromotionDetailId().getProductCatalog().getProductId()){
    			this.discountRate = i.getDiscountRate();
    			return;
    		}
    	});
    }
}
