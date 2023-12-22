

package com.example.demo.controller;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.CartItem;
import com.example.demo.dto.CountStatistic;
import com.example.demo.dto.Feedback;
import com.example.demo.dto.InvoiceStatus;
import com.example.demo.dto.OrderView;
import com.example.demo.security.userdetails.CustomerUserDetails;
import com.example.demo.service.AdminOrderService;
import com.example.demo.service.CartService;
import com.example.demo.service.OrderHistoryService;

@Controller
@RequestMapping("/customer/OrderHistory")
public class OrderHistoryController {
	@Autowired
	OrderHistoryService orderHistoryService;
	
    @GetMapping("")
    public String OrderHistoryPage() {
        return "orderhistory";
    }
    
    @GetMapping("/info")
    @ResponseBody
    public ResponseEntity<List<OrderView>> findOrderView(@RequestParam("status") String status,
    		@RequestParam("fromDay") Optional<Integer> fromDay, @AuthenticationPrincipal CustomerUserDetails customerUserDetails){
    	return ResponseEntity.ok(orderHistoryService.findOrderView(status, fromDay, customerUserDetails.getCustomerAccount().getAccountId()));
    }
    
    @GetMapping("/status")
	@ResponseBody
	public ResponseEntity<List<String>> getStatusList(){
		return ResponseEntity.ok(Arrays.asList(
				InvoiceStatus.NOTCONFIRMED, InvoiceStatus.AWAITINGDELIVERY, 
				InvoiceStatus.INPROGRESS, InvoiceStatus.COMPLETED,
				InvoiceStatus.UNDELIVERABLE, InvoiceStatus.CANCELLED));
	}
    
    @GetMapping("/status-statistic")
	@ResponseBody
	public ResponseEntity<List<CountStatistic>> orderStatusStatistic(@AuthenticationPrincipal CustomerUserDetails customerUserDetails){
		return ResponseEntity.ok(orderHistoryService.orderStatusStatistic(customerUserDetails.getCustomerAccount().getAccountId()));
	}
    
    @PostMapping("/send-feedback")
    @ResponseBody
    public ResponseEntity<Void> sendFeedback(@RequestBody Feedback feedback){
    	orderHistoryService.sendFeedback(feedback);
    	return new ResponseEntity<Void>(HttpStatus.OK);
    }
}