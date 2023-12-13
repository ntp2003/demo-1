package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.AccountFilter;
import com.example.demo.dto.ProductLot;
import com.example.demo.dto.ProductLotCatalogOption;
import com.example.demo.dto.ProductLotFilter;
import com.example.demo.dto.ProductLotImportItem;
import com.example.demo.dto.ProductLotImportItemDetails;
import com.example.demo.security.userdetails.AdminUserDetails;
import com.example.demo.service.AdminProductLotService;

@Controller
@RequestMapping("/admin/ProductLot")
public class AdminProductLotController {
	@Autowired
	AdminProductLotService adminProductLotService;
	
	@GetMapping("")
	public String getProductLotPage() {
		return "admin/productlot";
	}
	
	@PostMapping("")
	@ResponseBody
	public ResponseEntity<Page<ProductLot>> getProductLots(
			@PageableDefault(page = 0, size = 10, sort = { "importDate"}, direction = Direction.DESC) Pageable pageable, 
			@RequestBody ProductLotFilter productLotFilter){
		return ResponseEntity.ok(adminProductLotService.findProductLots(productLotFilter, pageable));
	}
	
	@GetMapping("/product-option")
	@ResponseBody
	public ResponseEntity<ProductLotCatalogOption> getProductOption(@RequestParam("productId") short productId){
		return ResponseEntity.ok(adminProductLotService.findOptionForProduct(productId));
	}
	
	@GetMapping("/lot-import-item-details")
	@ResponseBody
	public ResponseEntity<List<ProductLotImportItemDetails>> getLotImportItemDetails(@RequestParam("lotId") int lotId){
		return ResponseEntity.ok(adminProductLotService.findLotImportItemDetails(lotId));
	}
	
	@PostMapping("/import-product-lot")
	@ResponseBody
	public ResponseEntity<Void> importProductLot(@RequestBody List<ProductLotImportItem> pImportItems, @AuthenticationPrincipal AdminUserDetails adminUserDetails){
		if(adminProductLotService.importProductLot(adminUserDetails.getAdmin() ,pImportItems)) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
}
