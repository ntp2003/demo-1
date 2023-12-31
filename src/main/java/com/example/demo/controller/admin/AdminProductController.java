package com.example.demo.controller.admin;

import java.util.List;

import org.eclipse.tags.shaded.org.apache.bcel.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.ImageProduct;
import com.example.demo.dto.ProductCatalog;
import com.example.demo.dto.ProductCategory;
import com.example.demo.dto.ProductType;
import com.example.demo.service.AdminProductService;

@Controller
@RequestMapping("/admin")
public class AdminProductController {
	@Autowired
	AdminProductService adminProductService;

	@GetMapping("/Product")
	public String loginAdminPage() {
		return "admin/product";
	}

	@GetMapping("/product-list")
	@ResponseBody
	public ResponseEntity<Page<ProductCatalog>> findProductCatalog(
			@PageableDefault(page = 0, size = 10, sort = { "productName"}, direction = Direction.ASC) Pageable pageable,
			@RequestParam(name =  "containing", defaultValue = "") String containing) {
		if(containing.isEmpty())
			return ResponseEntity.ok(adminProductService.findProductCatalog(pageable));
		return ResponseEntity.ok(adminProductService.findProductCatalog(containing, pageable));
	}

	@PostMapping("/add-product")
	@ResponseBody
	public ResponseEntity<ProductCatalog> addProductCatalog(@RequestBody ProductCatalog pCatalog) {
		ProductCatalog productCatalog = adminProductService.saveProductCatalog(pCatalog);

		if (productCatalog == null) {
			return new ResponseEntity<ProductCatalog>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(productCatalog);
	}
	

	@DeleteMapping("/delete-product")
	@ResponseBody
	public ResponseEntity<Void> deleteProductCatalog(@RequestParam("productId") short productId) {
		if (adminProductService.deleteProductCatalog(productId)) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/product-category-list")
	@ResponseBody
	public ResponseEntity<List<ProductCategory>> findProductCategories(@RequestParam("productId") short productId) {
		return ResponseEntity.ok(adminProductService.findProductCategories(productId));
	}
	
	@PostMapping("/add-product-category")
	@ResponseBody
	public ResponseEntity<ProductCategory> addProductCategory(@RequestBody ProductCategory pCategory){
		ProductCategory productCategory = adminProductService.saveProductCategory(pCategory);
		
		if(productCategory == null) {
			return new ResponseEntity<ProductCategory>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(productCategory);
	}
	
	@DeleteMapping("/delete-product-category")
	@ResponseBody
	public ResponseEntity<Void> deleteProductCategory(@RequestParam("productCategoryId") int productCategoryId){
		if(adminProductService.deleteProductCategory(productCategoryId)) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/upload-images")
	@ResponseBody
	public ResponseEntity<Void> uploadImages
	(@RequestParam("productCategoryId") int productCategoryId, @RequestParam("dataURL") String dataURL){
		if(adminProductService.uploadImages(productCategoryId, dataURL)) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/get-images")
	@ResponseBody
	public ResponseEntity<List<ImageProduct>> getProductImages(@RequestParam("productCategoryId") int productCategoryId) {
		return ResponseEntity.ok(adminProductService.getProductImages(productCategoryId));
	}
	
	@DeleteMapping("/delete-images")
	@ResponseBody
	public ResponseEntity<Void> deleteImage(@RequestParam("productCategoryId") int productCategoryId) {
		if(adminProductService.deleteImage(productCategoryId)) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/product-type")
	@ResponseBody
	public ResponseEntity<List<ProductType>> getProductTypes(){
		return ResponseEntity.ok(adminProductService.productTypes());
	}
}
