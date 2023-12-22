

package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.CartItem;
import com.example.demo.security.userdetails.CustomerUserDetails;
import com.example.demo.service.CartService;

@Controller
@RequestMapping("/customer/OrderHistory")
public class OrderHistoryController {
	@Autowired
	CartService cartService;
	
    @GetMapping("")
    public String OrderHistoryPage() {
        return "orderhistory";
    }
}