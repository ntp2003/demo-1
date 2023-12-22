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
@RequestMapping("/customer/Cart")
public class ShoppingCartController {
	@Autowired
	CartService cartService;
	
    @GetMapping("")
    public String CartPage() {
        return "shoppingcart";
    }
    
    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Void> updateCart
    (@RequestParam("stockInventoryId") int stockInventoryId,@RequestParam("quantity") int quantity,
    		@AuthenticationPrincipal CustomerUserDetails customerUserDetails){
    	if(cartService.updateCart(stockInventoryId, quantity, customerUserDetails.getCustomerAccount().getAccountId()))
    		return new ResponseEntity<Void>(HttpStatus.OK);
    	return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }
    
    @DeleteMapping("/delete")
    @ResponseBody 
    public ResponseEntity<Void> deleteCartItem(@RequestParam("stockInventoryId") int stockInventoryId,
    		@AuthenticationPrincipal CustomerUserDetails customerUserDetails){
    	if(cartService.deleteCartItem(stockInventoryId, customerUserDetails.getCustomerAccount().getAccountId()))
    		return new ResponseEntity<Void>(HttpStatus.OK);
    	return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping("/count")
    @ResponseBody
    public ResponseEntity<Long> countCartItem(@AuthenticationPrincipal CustomerUserDetails customerUserDetails){
    	return ResponseEntity.ok(cartService.countCartItem(customerUserDetails.getCustomerAccount().getAccountId()));
    }
    
    @GetMapping("/info")
    @ResponseBody
    public ResponseEntity<List<CartItem>> findCartItem(@AuthenticationPrincipal CustomerUserDetails customerUserDetails){
    	return ResponseEntity.ok(cartService.findCartItem(customerUserDetails.getCustomerAccount().getAccountId()));
    }
}
