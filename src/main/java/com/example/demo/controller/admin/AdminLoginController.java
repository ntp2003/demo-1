package com.example.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminLoginController {
	@GetMapping("/admin/Login")
	public String loginAdminPage() {
		return "admin/login";
	}
	
	@PostMapping("/admin/login_success_handler")
	public String loginAdminSuccessHandler() {
		return "redirect:/admin/Dashboard";
	}
	

	
	@PostMapping("/admin/login_failure_handler")
	public String loginAdminFailureHandler() {
		System.out.println("Fail");
		return "admin/login";
	}
}
