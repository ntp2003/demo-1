package com.example.demo.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.example.demo.model.ProductCatalog;
import com.example.demo.model.ProductCategory;
import com.example.demo.model.StockDetails;

import lombok.Data;

@Data
public class ProductLotCatalogOption {
	private short productId;
	private String productName;
	private Map<String, Map<String, Object> > optionMap;
	
	public ProductLotCatalogOption(ProductCatalog pCatalog) {
		Map<String, Map<String, Object>> resultMap = new HashMap<String, Map<String, Object>>();
		
		for (ProductCategory pCategory : pCatalog.getProductCategory()) {
			Map<String, Object> categoryMap = new HashMap<String, Object>();
			Map<String, String> categorySizeMap = new HashMap<String, String>();
			
			categoryMap.put("color", pCategory.getColor());
			for (StockDetails item : pCategory.getStockDetails()) {
				categorySizeMap.put(String.valueOf(item.getStockInventoryId()), item.getSize().getSizeName());
			}
			categoryMap.put("sizeOption", categorySizeMap);
			resultMap.put(String.valueOf(pCategory.getProductCategoryId()), categoryMap);
		}
		this.optionMap = resultMap;
		this.productName = pCatalog.getProductName();
		this.productId = pCatalog.getProductId();
	}
}
