package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String loginPage(HttpSession session) {
//		if (session.getAttribute("customer") != null) {
//			return "redirect:/Home";
//		}
		return "login";
	}
	
	@GetMapping("/admin/Login")
	public String loginAdminPage(HttpSession session) {
//		if (session.getAttribute("customer") != null) {
//			return "redirect:/Home";
//		}
		return "admin/login";
	}
	
	@PostMapping("/login_success_handler")
	public String loginSuccessHandler() {
		// perform audit action
		return "home";
	}

	@PostMapping("/login_failure_handler")
	public String loginFailureHandler() {
		// perform audit action
		System.out.println("Fail");
		return "login";
	}
	
	@PostMapping("/admin/login_failure_handler")
	public String loginAdminFailureHandler() {
		// perform audit action
		System.out.println("Fail");
		return "admin/login";
	}
	
//	@PostMapping
//	public String loginCustomerAccount(ModelMap model,HttpSession session ,@RequestParam("email") String email, @RequestParam("password") String password) {
//		try {
//			CustomerAccount customer = customerService.validateLoginInfo(email, password);
//			session.setAttribute("customer", customer);
//			model.addAttribute("messagelogin", "");
//			return "redirect:/Home";
//		} catch (Exception e) {
//			String message = e.getMessage();
//			
//			model.addAttribute("messagelogin", message);
//			
//			return "login";
//		}
//	}
}
