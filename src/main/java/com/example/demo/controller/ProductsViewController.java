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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.ProductDetail;
import com.example.demo.dto.ProductFilter;
import com.example.demo.dto.ProductSearchItem;
import com.example.demo.dto.ProductType;
import com.example.demo.dto.ProductViewItem;
import com.example.demo.service.ProductsViewService;

@Controller
public class ProductsViewController {
	@Autowired
	ProductsViewService productsViewService;
    
    @GetMapping(value = {"/product"})
    public String SanPhamPage() {
        return "productall";
    }

    
    @GetMapping("/product/color")
    @ResponseBody
    public ResponseEntity<List<String>> getColors(){
    	return  ResponseEntity.ok(productsViewService.colors());
    }
    
    @GetMapping("/product/brand")
    @ResponseBody
    public ResponseEntity<List<String>> getBrands(){
    	return  ResponseEntity.ok(productsViewService.brands());
    }
    
    @GetMapping("/product/type")
    @ResponseBody
    public ResponseEntity<List<ProductType>> getTypes(){
    	return  ResponseEntity.ok(productsViewService.productTypes());
    }
    
    @PostMapping("/product/filter")
    @ResponseBody
    public ResponseEntity<Page<ProductViewItem>> getFilteredProducts
    (@PageableDefault(page = 0, size = 12, sort = { "productName"}, direction = Direction.ASC) Pageable pageable,
    		@RequestBody(required=false) ProductFilter productFilter){
    	if(productFilter == null) {
    		productFilter = new ProductFilter();
    	}
    	return ResponseEntity.ok(productsViewService.findFilteredProduct(productFilter, pageable));
    }
    
    @GetMapping("/product/search")
    @ResponseBody
    public ResponseEntity<List<ProductSearchItem>> searchProduct(@RequestParam("searchValue") String searchValue){
    	return ResponseEntity.ok(productsViewService.findItemBySearch(searchValue));
    }
    
    @GetMapping("/product/detail/{id}")
    public String getProductDetailPage() {
    	return "productdetails";
    }
    
    @GetMapping("/product/detail/info/{id}")
    @ResponseBody
    public ResponseEntity<ProductDetail> getProductDetailInfo(@PathVariable("id") short id) {
    	return ResponseEntity.ok(productsViewService.getProductDetailInfo(id));
    }
}
