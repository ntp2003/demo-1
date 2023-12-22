package com.example.demo.controller.admin;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminLoginController {
	@GetMapping("/admin/Login")
	public String loginAdminPage() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			if (authentication.getAuthorities().stream().filter(i -> i.getAuthority().equals("ROLE_ADMIN")).count() > 0)
					return "redirect:/admin/Dashboard";
		}
		return "admin/login";
	}
	
	@PostMapping("/admin/login_success_handler")
	public String loginAdminSuccessHandler() {
		return "redirect:/admin/Dashboard";
	}
	
	@PostMapping("/admin/login_failure_handler")
	public String loginAdminFailureHandler() {
		System.out.println("Fail");
		return "redirect:/admin/Login?error=true";
	}
}
