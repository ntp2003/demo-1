package com.example.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductViewItem;
import com.example.demo.model.ProductType;
import com.example.demo.model.QProductCatalog;
import com.example.demo.repository.ProductCatalogRepo;
import com.example.demo.repository.ProductCategoryRepo;
import com.example.demo.repository.ProductTypeRepo;
import com.google.gson.annotations.Since;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Visitor;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

@Service
public class ProductsViewServiceImpl implements ProductsViewService {
	@Autowired
	ProductCatalogRepo productCatalogRepo;

	@Autowired
	ProductCategoryRepo productCategoryRepo;
	
	@Autowired
	ProductTypeRepo productTypeRepo;
	
	@Override
	public Page<ProductViewItem> findFilteredProduct(ProductFilter productFilter, Pageable pageable) {
		QProductCatalog qProductCatalog = QProductCatalog.productCatalog;
		BooleanExpression predicate = qProductCatalog.productCategory.isNotEmpty();

		if (productFilter.getColors() != null) {
			predicate.and(qProductCatalog.productCategory.any().color.in(productFilter.getColors()));
		}
		if (productFilter.getProductTypes() != null) {
			predicate.and(qProductCatalog.productType
					.in(productFilter.getProductTypes().stream().map(i -> new ProductType(i)).toList()));
		}
		if (productFilter.getMinPrice() != null) {
			predicate.and(qProductCatalog.productCategory.any().price.goe(productFilter.getMinPrice()));
		}
		if (productFilter.getMaxPrice() != null) {
			predicate.and(qProductCatalog.productCategory.any().price.loe(productFilter.getMaxPrice()));
		}

		return productCatalogRepo.findAll(predicate, pageable).map(i -> new ProductViewItem(i));
	}

	@Override
	public List<com.example.demo.dto.ProductType> productTypes() {
		return productTypeRepo.findAll().stream().map(i -> new com.example.demo.dto.ProductType(i)).toList();
	}

	@Override
	public List<String> colors() {
		return productCategoryRepo.findDistinctColor();
	}
}
