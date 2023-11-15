package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckoutController {
    @RequestMapping(value = {"/","/Checkout"})
    public String CheckoutPage() {
        return "checkout";
    }
}
