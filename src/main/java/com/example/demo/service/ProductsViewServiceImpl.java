package com.example.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.QProductCatalog;
import com.example.demo.repository.ProductCatalogRepo;
import com.google.gson.annotations.Since;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Visitor;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

@Service
public class ProductsViewServiceImpl implements ProductsViewService{
	@Autowired
	ProductCatalogRepo productCatalogRepo;
	
	@Override
	public Page<?> findFilteredProduct(ProductFilter productFilter, Pageable pageable) {
		QProductCatalog qProductCatalog = QProductCatalog.productCatalog;
		BooleanExpression colorFilter = Expressions.asBoolean(true).isTrue();
		Predicate predicate = new BooleanBuilder();
		if(!productFilter.getColors().isEmpty()) {
			for (String color : productFilter.getColors()) {
				colorFilter.and(qProductCatalog.productCategory.any().productCategory.color.eq(color));
			}
		}
		return productCatalogRepo.findAll(predicate, pageable);
	}
}
