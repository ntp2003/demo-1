package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.CustomerAccount;
import com.example.demo.service.CustomerService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	public CustomerService customerService;

	@GetMapping(value = {"/Login","/customer/Login"})
	public String loginPage() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			authentication.getAuthorities().forEach(i -> System.out.println(i.getAuthority()));
			if (authentication.getAuthorities().stream().filter(i -> i.getAuthority().equals("ROLE_CUSTOMER")).count() > 0)
				return "redirect:/Home";
		}
		return "login";
	}
	
	@PostMapping("/login_success_handler")
	public String loginCustomerSuccessHandler() throws Exception {
		customerService.recordSuccessLog();
		return "redirect:/Home";
	}

	@PostMapping("/login_failure_handler")
	public String loginFailureHandler() {
	    System.out.println("Fail");
	    return "redirect:/Login?error=true";
	}
}
