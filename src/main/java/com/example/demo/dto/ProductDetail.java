package com.example.demo.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.ProductCatalog;
import com.example.demo.model.ProductCategory;
import com.example.demo.model.Promotion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDetail extends ProductViewItem {
	private LocalDate releaseDate;
	private String origin;
	private String brand;
	private String description;
	private List<CategoryItem> categoriedetails;

	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	public class CategoryItem extends ProductViewItem.CategoryItem {
		private List<Stock> stocks;
	}

	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	public class Stock {
		private int stockInventoryId;
		private int stock;
		private String sizeName;
	}

	public ProductDetail(ProductCatalog productCatalog) {
		this.productId = productCatalog.getProductId();
		this.productName = productCatalog.getProductName();
		this.purchaseCount = productCatalog.getPurchaseCount();
		this.releaseDate = productCatalog.getReleaseDate();
		this.origin = productCatalog.getOrigin();
		this.brand = productCatalog.getBrand();
		this.description = productCatalog.getDescription();
		this.categoriedetails = new ArrayList<>();

		for (ProductCategory pCategory : productCatalog.getProductCategory()) {
			CategoryItem categoryItem = new CategoryItem();

			categoryItem.setProductCategoryId(pCategory.getProductCategoryId());
			categoryItem.setColor(pCategory.getColor());
			categoryItem.setPrice(pCategory.getPrice());
			categoryItem.setImages(pCategory.getImageProduct().stream().map(i -> i.getImage()).limit(6).toList());
			categoryItem.setStocks(new ArrayList<>());
			pCategory.getStockDetails().forEach(i -> {
				Stock stock = new Stock();
				
				stock.setStockInventoryId(i.getStockInventoryId());
				stock.setStock(i.getStock());
				stock.setSizeName(i.getSize().getSizeName());
				categoryItem.getStocks().add(stock);
			});
			this.categoriedetails.add(categoryItem);
		}
	}

	public ProductDetail(ProductCatalog productCatalog, Optional<Promotion> promotion) {
		this(productCatalog);
		if (promotion.isPresent()) {
			promotion.get().getPromotionDetail().forEach(i -> {
				if (this.productId == i.getPromotionDetailId().getProductCatalog().getProductId()) {
					this.discountRate = i.getDiscountRate();
					return;
				}
			});
		}
	}
}
