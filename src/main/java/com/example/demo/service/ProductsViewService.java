package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductType;
import com.example.demo.dto.ProductViewItem;

import lombok.Data;

@Service
public interface ProductsViewService {
	public Page<ProductViewItem> findFilteredProduct(ProductFilter productFilter, Pageable pageable);
	
	public List<ProductType> productTypes();
	
	public List<String> colors();
	
	@Data
	public class ProductFilter {
		List<String> colors;
		List<Short> productTypes;
		String specialType;
		BigDecimal minPrice;
		BigDecimal maxPrice;
	}
}
