package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.ProductType;
import com.example.demo.dto.ProductViewItem;
import com.example.demo.service.ProductsViewService;
import com.example.demo.service.ProductsViewService.ProductFilter;

@Controller
public class ProductsViewController {
	@Autowired
	ProductsViewService productsViewService;
	
    @GetMapping(value = {"/Giay"})
    public String GiayPage() {
        return "productgiay";
    }
    @GetMapping(value = {"/Balo"})
    public String BaloPage() {
        return "productbalo";
    }
    @GetMapping(value = {"/SanPham"})
    public String SanPhamPage() {
        return "productall";
    }
    
    @GetMapping("/product/color")
    @ResponseBody
    public ResponseEntity<List<String>> getColors(){
    	return  ResponseEntity.ok(productsViewService.colors());
    }
    
    @GetMapping("/product/type")
    @ResponseBody
    public ResponseEntity<List<ProductType>> getTypes(){
    	return  ResponseEntity.ok(productsViewService.productTypes());
    }
    
    @PostMapping("/product/filter")
    @ResponseBody
    public ResponseEntity<Page<ProductViewItem>> getFilteredProducts
    (@PageableDefault(page = 0, size = 10, sort = { "productName"}, direction = Direction.ASC) Pageable pageable,
    		@RequestBody(required=false) ProductFilter productFilter){
    	if(productFilter == null) {
    		productFilter = new ProductFilter();
    	}
    	return ResponseEntity.ok(productsViewService.findFilteredProduct(productFilter, pageable));
    }
}
