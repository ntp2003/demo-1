package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.tags.shaded.org.apache.bcel.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ImageProduct;
import com.example.demo.dto.ProductCatalog;
import com.example.demo.dto.ProductCategory;
import com.example.demo.dto.ProductType;
import com.example.demo.model.Size;
import com.example.demo.model.StockDetails;
import com.example.demo.repository.ImageProductRepo;
import com.example.demo.repository.ProductCatalogRepo;
import com.example.demo.repository.ProductCategoryRepo;
import com.example.demo.repository.ProductTypeRepo;
import com.example.demo.repository.SizeRepo;
import com.example.demo.repository.SizeRepo.SizeId;
import com.example.demo.repository.StockDetailsRepo;
import com.example.demo.util.Converter;
import com.example.demo.util.FirebaseUtil;

@Service
public class AdminProductServiceImpl implements AdminProductService {
	@Autowired
	private ProductTypeRepo productTypeRepo;
	@Autowired
	private ProductCatalogRepo productCatalogRepo;
	@Autowired
	private ProductCategoryRepo productCategoryRepo;
	@Autowired
	private ImageProductRepo imageProductRepo;
	@Autowired
	private StockDetailsRepo stockDetailsRepo;

	@Override
	public Page<ProductCatalog> findProductCatalog(Pageable pageable) {
		return productCatalogRepo.findAll(pageable).map(i -> new ProductCatalog(i));
	}
	
	@Override
	public Page<ProductCatalog> findProductCatalog(String containing, Pageable pageable) {
		return productCatalogRepo.findByProductNameContaining(containing ,pageable).map(i -> new ProductCatalog(i));
	}

	@Override
	public ProductCatalog saveProductCatalog(ProductCatalog productCatalog) {
		try {
			return new ProductCatalog(productCatalogRepo.save(productCatalog.toModel()));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteProductCatalog(short productId) {
		try {
			productCatalogRepo.deleteById(productId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<ProductCategory> findProductCategories(short productId) {
		com.example.demo.model.ProductCatalog pCatalog = new com.example.demo.model.ProductCatalog();
		pCatalog.setProductId(productId);
		List<ProductCategory> productCategories = productCategoryRepo.findByProductCatalog(pCatalog).stream()
				.map((i) -> new ProductCategory(i)).toList();
		return productCategories;
	}

	@Override
	public ProductCategory saveProductCategory(ProductCategory productCategory) {
		try {
			com.example.demo.model.ProductCategory pCategory = productCategoryRepo.save(productCategory.toModel());
			com.example.demo.model.ProductType pType = productCatalogRepo
					.findById(pCategory.getProductCatalog().getProductId()).get().getProductType();
			pType = productTypeRepo.findById(pType.getProductTypeId()).get();

			for (Size size : pType.getSize()) {
				StockDetails stockDetails = new StockDetails();

				stockDetails.setStock(0);
				stockDetails.setProductCategory(pCategory);
				stockDetails.setSize(size);

				stockDetailsRepo.save(stockDetails);
			}

			return new ProductCategory(pCategory);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteProductCategory(int productCategoryId) {
		try {
			productCategoryRepo.deleteById(productCategoryId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean uploadImages(int productCategoryId, String dataURL) {
		try {
			String url = FirebaseUtil.Upload(Converter.DataURLImagetoFile(dataURL));
			com.example.demo.model.ImageProduct imageProduct = new com.example.demo.model.ImageProduct();
			imageProduct.setImage(url);
			com.example.demo.model.ProductCategory pCategory = new com.example.demo.model.ProductCategory();
			pCategory.setProductCategoryId(productCategoryId);
			imageProduct.setProductCategory(pCategory);
			imageProductRepo.save(imageProduct);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<ImageProduct> getProductImages(int productCategoryId) {
		com.example.demo.model.ProductCategory pCategory = new com.example.demo.model.ProductCategory();
		pCategory.setProductCategoryId(productCategoryId);
		return imageProductRepo.findImageProductsByProductCategory(pCategory).stream().map(i -> new ImageProduct(i))
				.toList();
	}

	@Override
	public boolean deleteImage(int productCategoryId) {
		try {
			com.example.demo.model.ProductCategory pCategory = new com.example.demo.model.ProductCategory();
			pCategory.setProductCategoryId(productCategoryId);
			List<com.example.demo.model.ImageProduct> imageProducts = imageProductRepo.findImageProductsByProductCategory(pCategory);
			for (com.example.demo.model.ImageProduct imageProduct : imageProducts) {
				imageProductRepo.deleteById(imageProduct.getImageId());
				FirebaseUtil.Delete(imageProduct.getImage());
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<ProductType> productTypes() {
		return productTypeRepo.findAll().stream().map(i -> new ProductType(i)).toList();
	}

}
