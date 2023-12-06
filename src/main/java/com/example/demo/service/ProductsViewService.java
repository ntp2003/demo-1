package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service
public interface ProductsViewService {
	public Page<?> findFilteredProduct(ProductFilter productFilter, Pageable pageable);
	
	@Data
	public class ProductFilter {
		List<String> colors;
		List<Short> productTypes;
		String specialType;
	}
}
