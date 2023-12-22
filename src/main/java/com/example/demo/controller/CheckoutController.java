package com.example.demo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.CheckoutInfo;
import com.example.demo.security.userdetails.CustomerUserDetails;
import com.example.demo.service.CartService;
import com.example.demo.service.CheckoutService;

@Controller
@RequestMapping("/customer/Checkout")
public class CheckoutController {
	@Autowired
	CartService cartService;
	
	@Autowired
	CheckoutService checkoutService;
	
    @GetMapping("")
    public String CheckoutPage(@AuthenticationPrincipal CustomerUserDetails customerUserDetails) {
    	if(cartService.countCartItem(customerUserDetails.getCustomerAccount().getAccountId()) == 0)
    		return "redirect:/customer/Cart";
        return "checkout";
    }
    
    @GetMapping("/info")
    @ResponseBody
    public ResponseEntity<CheckoutInfo> getCheckoutInfo(@AuthenticationPrincipal CustomerUserDetails customerUserDetails){
    	return ResponseEntity.ok(checkoutService.getCheckoutInfo(customerUserDetails.getCustomerAccount().getAccountId()));
    }
    
    @PostMapping("")
    @ResponseBody
    public ResponseEntity<String> getCheckout(@RequestBody CheckoutInfo checkoutInfo, 
    		@AuthenticationPrincipal CustomerUserDetails customerUserDetails){
    	try {
			CustomerUserDetails updatedCustomer = checkoutService.getCheckout(checkoutInfo, customerUserDetails.getCustomerAccount().getAccountId());
			if(updatedCustomer != null) {
				Authentication authentication = new UsernamePasswordAuthenticationToken(updatedCustomer,updatedCustomer.getPassword(), updatedCustomer.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			return ResponseEntity.status(200).location(URI.create("/customer/Checkout/complete")).build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
    }
    
    @GetMapping("/complete")
    public String getCompletePage() {
    	return "checkoutComplete";
    }
}
