package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.ProductView;
import com.example.demo.dto.ProductViewMode;
import com.example.demo.service.ProductsViewService;

@Controller
public class HomeController {
	@Autowired
	ProductsViewService productsViewService;
	
    @GetMapping({"/","/Home","/customer"})
    public String homePage() {
        return "home";
    }
    
    @GetMapping("/product/view")
    @ResponseBody
    public ResponseEntity<List<ProductView>> getProductViewMode(@RequestParam("mode") ProductViewMode mode){
    	return ResponseEntity.ok(productsViewService.getProductViewMode(mode));
    }
    
    @GetMapping("/promotion/exists")
    @ResponseBody
    public ResponseEntity<Boolean> promotionExists(){
    	return ResponseEntity.ok(productsViewService.findCurrentPromotionSimple().isPresent());
    }
}