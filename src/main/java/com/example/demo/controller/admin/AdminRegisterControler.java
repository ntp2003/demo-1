package com.example.demo.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.Admin;
import com.example.demo.dto.CustomerAccount;

@Controller
public class AdminRegisterControler {
	
	
	@GetMapping("/admin/Register")
	public ModelAndView adminRegisterPage() {
		return new ModelAndView("admin/register", "newAccount", new Admin());
	}
	
	@PostMapping("/admin/Register")
	public String registerAdmin(@ModelAttribute("newAccount")Admin newAccount) {
		return "admin/register";
	}
}
