package com.example.demo.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.example.demo.model.InvoiceDetail;
import com.example.demo.model.ShoppingCart;
import com.example.demo.model.StockDetails;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class CheckoutItemDetail implements Serializable{
	int stockInventoryId;
	short productId;
	String productName;
	String sizeName;
	String color;
	int quantity;
	BigDecimal price;
	BigDecimal discount;

	public CheckoutItemDetail(ShoppingCart shoppingCart) {
		StockDetails stockDetails = shoppingCart.getShoppingCartId().getStockDetails();
		quantity = shoppingCart.getQuantity();
		if (quantity <= 0 || quantity > stockDetails.getStock())
			throw new RuntimeException("Stock is not enough !!!");
		stockInventoryId = stockDetails.getStockInventoryId();
		productId = stockDetails.getProductCategory().getProductCatalog().getProductId();
		productName = stockDetails.getProductCategory().getProductCatalog().getProductName();
		sizeName = stockDetails.getSize().getSizeName();
		color = stockDetails.getProductCategory().getColor();
		price = stockDetails.getProductCategory().getPrice();
		discount =  BigDecimal.valueOf(0);
	}
	
	public CheckoutItemDetail(InvoiceDetail invoiceDetail) {
		StockDetails stockDetails = invoiceDetail.getInvoiceDetailId().getStockDetails();
		
		stockInventoryId = stockDetails.getStockInventoryId();
		productId = stockDetails.getProductCategory().getProductCatalog().getProductId();
		productName = stockDetails.getProductCategory().getProductCatalog().getProductName();
		sizeName = stockDetails.getSize().getSizeName();
		color = stockDetails.getProductCategory().getColor();
		quantity = invoiceDetail.getQuantity();
		price = invoiceDetail.getOriginalPrice();
		discount = invoiceDetail.getDiscount();
	}
}
