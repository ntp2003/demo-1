package com.example.demo.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ImageProduct;
import com.example.demo.dto.ProductCatalog;
import com.example.demo.dto.ProductCategory;
import com.example.demo.dto.ProductType;

@Service
public interface AdminProductService {
	public List<ProductType> productTypes();
	
	public Page<ProductCatalog> findProductCatalog(Pageable pageable);
	
	public ProductCatalog saveProductCatalog(ProductCatalog productCatalog);
	
	public boolean deleteProductCatalog(short productId);
	
	public List<ProductCategory> findProductCategories(short productId);
	
	public ProductCategory saveProductCategory(ProductCategory productCategory);
	
	public boolean deleteProductCategory(int productCategoryId);
	
	public boolean uploadImages(int productCategoryId, String dataURLs);
	
	public List<ImageProduct> getProductImages(int productCategoryId);
	
	public boolean deleteImage(ImageProduct imageProduct);
}
