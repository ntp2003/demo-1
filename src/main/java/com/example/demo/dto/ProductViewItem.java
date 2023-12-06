package com.example.demo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.demo.model.ProductCatalog;
import com.example.demo.model.ProductCategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductViewItem implements Serializable{
	private short productId;
    private String productName;
    private int purchaseCount;
    private List<CategoryItem> categories;
    
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class CategoryItem{
    	private int productCategoryId;
        private String color;
        private BigDecimal price;
        private List<String> images;
    }
    
    public ProductViewItem(ProductCatalog productCatalog) {
    	this.productId = productCatalog.getProductId();
    	this.productName = productCatalog.getProductName();
    	this.purchaseCount = productCatalog.getPurchaseCount();
    	this.categories = new ArrayList<>();
    	
    	for (ProductCategory pCategory : productCatalog.getProductCategory()) {
    		CategoryItem categoryItem = new CategoryItem();
    		
    		categoryItem.setProductCategoryId(pCategory.getProductCategoryId());
    		categoryItem.setColor(pCategory.getColor());
    		categoryItem.setPrice(pCategory.getPrice());
    		categoryItem.setImages(pCategory.getImageProduct().stream().map(i -> i.getImage()).limit(2).toList());
    		
    		this.categories.add(categoryItem);
		}
    }
}
