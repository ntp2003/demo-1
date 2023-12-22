package com.example.demo.controller.admin;

import java.util.Arrays;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.AdminOrderDetail;
import com.example.demo.dto.AdminOrderFilter;
import com.example.demo.dto.CountStatistic;
import com.example.demo.dto.InvoiceStatus;
import com.example.demo.dto.PurchaseInvoice;
import com.example.demo.service.AdminOrderService;

@Controller
@RequestMapping("/admin/Order")
public class AdminOrderController {
	@Autowired
	AdminOrderService adminOrderService;
	
	@GetMapping("")
	public String loginAdminPage() {
		return "admin/order";
	}
	
	@GetMapping("/status")
	@ResponseBody
	public ResponseEntity<List<String>> getStatusList(){
		return ResponseEntity.ok(Arrays.asList(
				InvoiceStatus.NOTCONFIRMED, InvoiceStatus.AWAITINGDELIVERY, 
				InvoiceStatus.INPROGRESS, InvoiceStatus.COMPLETED,
				InvoiceStatus.UNDELIVERABLE, InvoiceStatus.CANCELLED));
	}
	
	@PostMapping("")
	@ResponseBody
	public ResponseEntity<Page<PurchaseInvoice>> getPurchaseInvoicePage(@RequestBody AdminOrderFilter filter,
			@PageableDefault(page = 0, size = 10, sort = { "createdTime"}, direction = Direction.DESC) Pageable pageable){
		return ResponseEntity.ok(adminOrderService.getPurchaseInvoicePage(filter, pageable));
	}
	
	@PutMapping("/update")
	@ResponseBody
	public ResponseEntity<PurchaseInvoice> updateStatus(@RequestParam("purchaseHistoryId") int purchaseHistoryId,
		@RequestParam("updateStatus") String updateStatus){
		return ResponseEntity.ok(adminOrderService.updateStatus(purchaseHistoryId, updateStatus));
	}
	
	@GetMapping("/detail")
	@ResponseBody
	public ResponseEntity<AdminOrderDetail> getAdminOrderDetail(@RequestParam("purchaseHistoryId") int purchaseHistoryId){
		return ResponseEntity.ok(adminOrderService.getAdminOrderDetail(purchaseHistoryId));
	}
	
	@GetMapping("/status-statistic")
	@ResponseBody
	public ResponseEntity<List<CountStatistic>> orderStatusStatistic(){
		return ResponseEntity.ok(adminOrderService.orderStatusStatistic());
	}
}
