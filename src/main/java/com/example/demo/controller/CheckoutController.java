package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.ShoppingCart;
import com.example.demo.repository.ShoppingCartRepo;

@Controller
@RequestMapping("/customer/Checkout")
public class CheckoutController {
	@Autowired
	ShoppingCartRepo shoppingCartRepo;
	
    @RequestMapping("")
    public String CheckoutPage() {
        return "checkout";
    }
    
    @RequestMapping(value = {"/a"})
    @ResponseBody
    public List<ShoppingCart> a() {
        return shoppingCartRepo.findAll();
    }
}
