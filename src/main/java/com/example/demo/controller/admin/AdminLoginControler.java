package com.example.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminLoginControler {
	@GetMapping("/admin/Login")
	public String loginAdminPage() {
		return "admin/login";
	}
	
	@PostMapping("/admin/login_success_handler")
	public String loginAdminSuccessHandler() {
		// perform audit action
		return "redirect:/admin/Register";
	}
	

	
	@PostMapping("/admin/login_failure_handler")
	public String loginAdminFailureHandler() {
		// perform audit action
		System.out.println("Fail");
		return "admin/login";
	}
}
