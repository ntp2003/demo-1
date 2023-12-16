package com.example.demo.controller.admin;

import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.ProductLotFilter;
import com.example.demo.dto.Promotion;
import com.example.demo.dto.PromotionFilter;
import com.example.demo.service.AdminPromotionService;

@Controller
@RequestMapping("/admin/Promotion")
public class AdminPromotionController {
	@Autowired
	AdminPromotionService adminPromotionService;
	
	@GetMapping("")
	public String getPromotionPage() {
		return "admin/promotion";
	}
	
	@GetMapping("/find-product")
	@ResponseBody
	public ResponseEntity<Entry<Short, String>> findProduct(@RequestParam("productId") short productId){
		return ResponseEntity.ok(adminPromotionService.findProductCatalog(productId));
	}
	
	@PostMapping("/add-promotion")
	@ResponseBody
	public ResponseEntity<Void> addPromotion(@RequestBody Promotion promotion){
		if(adminPromotionService.addPromotion(promotion))
			return new ResponseEntity<Void>(HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/delete-promotion")
	@ResponseBody
	public ResponseEntity<Void> deletePromotion(@RequestParam("promotionId") int promotionId){
		if(adminPromotionService.deletePromotion(promotionId))
			return new ResponseEntity<Void>(HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("")
	@ResponseBody
	public ResponseEntity<Page<Promotion>> getPromotionPage(@PageableDefault(page = 0, size = 10, sort = { "startTime"}, direction = Direction.DESC) Pageable pageable, 
			@RequestBody PromotionFilter promotionFilter){
		return ResponseEntity.ok(adminPromotionService.getPromotionPage(promotionFilter, pageable));
	}
}
