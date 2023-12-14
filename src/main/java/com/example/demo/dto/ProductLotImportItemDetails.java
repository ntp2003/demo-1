package com.example.demo.dto;

import com.example.demo.model.ProductCatalog;
import com.example.demo.model.ProductCategory;
import com.example.demo.model.ProductLotDetails;
import com.example.demo.model.StockDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductLotImportItemDetails {
	private short productId;
	private String productName;
	private String color;
	private String size;
	private int quantity;
	
	public ProductLotImportItemDetails(ProductLotDetails productLotDetails) {
		StockDetails stockDetails = productLotDetails.getProductLotDetailsId().getStockDetails();
		ProductCategory productCategory = stockDetails.getProductCategory();
		ProductCatalog productCatalog = productCategory.getProductCatalog();
		
		this.quantity = productLotDetails.getQuantity();
		this.size = stockDetails.getSize().getSizeName();
		this.color = productCategory.getColor();
		this.productName = productCatalog.getProductName();
		this.productId = productCatalog.getProductId();
	}
}
