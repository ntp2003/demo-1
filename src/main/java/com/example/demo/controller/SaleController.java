package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.ProductView;
import com.example.demo.dto.PromotionSimple;
import com.example.demo.service.ProductsViewService;

@Controller
@RequestMapping("/Sale")
public class SaleController {
	@Autowired
	ProductsViewService productsViewService;
	
	@GetMapping("")
    public String SalePage(Model model) {
        Optional<PromotionSimple> promotion = productsViewService.findCurrentPromotionSimple();
        if(promotion.isEmpty())
        	return "SaleComingSoon";
        model.addAttribute("promotion", promotion.get());
        return "sale";
    }
	
	@GetMapping("/info")
	@ResponseBody
	public ResponseEntity<List<ProductView>> getSaleItem(){
		return ResponseEntity.ok(productsViewService.findSaleProductViews());
	}
}
