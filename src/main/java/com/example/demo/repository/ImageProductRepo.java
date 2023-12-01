package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ImageProduct;
import com.example.demo.model.ProductCategory;

@Repository
public interface ImageProductRepo extends JpaRepository<ImageProduct, Integer>{
	List<ImageProduct> findImageProductsByProductCategory(ProductCategory productCategory);
}
