package com.example.demo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Optional;

import com.example.demo.model.InvoiceDetail;
import com.example.demo.model.StockDetails;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItem implements Serializable{
	int stockInventoryId;
	String productName;
	String color;
	String sizeName;
	String image;
	int quantity;
	BigDecimal price;
	BigDecimal discount;
	boolean canFeedback;
	
	public OrderItem(InvoiceDetail invoiceDetail) {
		StockDetails stockDetails = invoiceDetail.getInvoiceDetailId().getStockDetails();
		stockInventoryId = stockDetails.getStockInventoryId();
		productName = stockDetails.getProductCategory().getProductCatalog().getProductName();
		color = stockDetails.getProductCategory().getColor();
		sizeName = stockDetails.getSize().getSizeName();
		image = stockDetails.getProductCategory().getImageProduct().stream().findFirst().map(i -> i.getImage()).orElse(null);
		price = invoiceDetail.getOriginalPrice();
		discount = invoiceDetail.getDiscount();
		quantity = invoiceDetail.getQuantity();
	}
}
