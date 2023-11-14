package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
    @RequestMapping(value = {"/","/Home"})
    public String homePage() {
        return "home";
    }
    
    @RequestMapping(value = {"/customer"})
    public String hPage() {
        return "home";
    }
}