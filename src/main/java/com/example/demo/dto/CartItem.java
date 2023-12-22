package com.example.demo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Optional;

import com.example.demo.model.ShoppingCart;
import com.example.demo.model.StockDetails;

import lombok.Data;

@Data
public class CartItem implements Serializable{
	int stockInventoryId;
	short productId;
	String productName;
	String color;
	String sizeName;
	String image;
	int quantity;
	int stock;
	BigDecimal price;
	Optional<Short> discountRate;
	
	public CartItem(ShoppingCart shoppingCart, Optional<com.example.demo.model.Promotion> promotion) {
		StockDetails stockDetails = shoppingCart.getShoppingCartId().getStockDetails();
		stockInventoryId = stockDetails.getStockInventoryId();
		stock = stockDetails.getStock();
		quantity = shoppingCart.getQuantity();
		color = stockDetails.getProductCategory().getColor();
		productId = stockDetails.getProductCategory().getProductCatalog().getProductId();
		productName = stockDetails.getProductCategory().getProductCatalog().getProductName();
		image = stockDetails.getProductCategory().getImageProduct().stream().findFirst().map(i -> i.getImage()).orElse(null);
		sizeName = stockDetails.getSize().getSizeName();
		price = stockDetails.getProductCategory().getPrice();
		discountRate = promotion.map(i -> i.getPromotionDetail()
				.stream().filter(it -> it.getPromotionDetailId()
						.getProductCatalog().getProductId() == productId)
				.findFirst().map(it -> it.getDiscountRate())).orElse(null);
	}
}
