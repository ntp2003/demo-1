package com.example.demo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Promotion;
import com.example.demo.model.ShoppingCart;
import com.example.demo.model.StockDetails;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CheckoutInfo implements Serializable {
	protected BigDecimal originalPrice = BigDecimal.valueOf(0);
	protected BigDecimal discount = BigDecimal.valueOf(0);
	protected BigDecimal shippingFee = BigDecimal.valueOf(0);
	protected BigDecimal total = BigDecimal.valueOf(0);
	protected List<CheckoutItemDetail> itemDetails;
	protected String address;
	protected String phoneNumber;
	protected short paymentMethod;

	public CheckoutInfo(Iterable<ShoppingCart> cartItem, Optional<Promotion> promotion) {
		itemDetails = new ArrayList<>();
		cartItem.forEach(it -> {
			CheckoutItemDetail itemDetail = new CheckoutItemDetail(it);
			originalPrice = originalPrice.add(itemDetail.price.multiply(BigDecimal.valueOf(itemDetail.getQuantity())));
			if (promotion.isPresent()) {
				promotion.get().getPromotionDetail().forEach(i -> {
					if (itemDetail.productId == i.getPromotionDetailId().getProductCatalog().getProductId()) {
						itemDetail.discount = itemDetail.price.multiply(BigDecimal.valueOf(i.getDiscountRate()))
								.divide(BigDecimal.valueOf(100), RoundingMode.DOWN);
						discount.add(itemDetail.discount.multiply(BigDecimal.valueOf(itemDetail.getQuantity())));
						return;
					}
				});
			}
			itemDetails.add(itemDetail);
		});
		total = originalPrice.subtract(discount);
	}
}
