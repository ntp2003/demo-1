package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDetail;
import com.example.demo.dto.ProductFilter;
import com.example.demo.dto.ProductSearchItem;
import com.example.demo.dto.ProductType;
import com.example.demo.dto.ProductView;
import com.example.demo.dto.ProductViewItem;
import com.example.demo.dto.ProductViewMode;
import com.example.demo.dto.PromotionSimple;
import com.example.demo.model.Promotion;

import lombok.Data;

@Service
public interface ProductsViewService {
	public Page<ProductViewItem> findFilteredProduct(ProductFilter productFilter, Pageable pageable);
	
	public List<ProductType> productTypes();
	
	public List<String> colors();
	
	public List<String> brands();
	
	public List<ProductSearchItem> findItemBySearch(String searchValue);
	
	public List<ProductView> getProductViewMode(ProductViewMode mode);

	Optional<Promotion> findCurrentPromotion();
	
	ProductDetail getProductDetailInfo(short productId);
	
	Optional<PromotionSimple> findCurrentPromotionSimple();
	
	List<ProductView> findSaleProductViews();
}
