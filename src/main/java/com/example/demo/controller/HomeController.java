package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
    @GetMapping({"/","/Home"})
    public String homePage() {
        return "home";
    }
    
    @GetMapping({"/customer"})
    public String hPage() {
        return "home";
    }
}