package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.CustomerAccount;
import com.example.demo.service.CustomerService;

import jakarta.servlet.http.HttpSession;

@Controller
public class RegisterController {
	@Autowired
	public CustomerService customerService;
	
	@GetMapping("/Register")
	public ModelAndView RegisterPage(HttpSession session) {
		if(session.getAttribute("customer") != null) {
			return new ModelAndView("redirect:/Home");
		}
		return new ModelAndView("register", "newCustomer", new CustomerAccount());
	}
	
	@GetMapping("/admin/Register")
	public String adminRegisterPage(HttpSession session) {
		return "admin/register";
	}
	
	@PostMapping("/Register")
	public String register(ModelMap model, HttpSession session,@ModelAttribute("newCustomer")CustomerAccount newCustomer) {
		CustomerAccount customer;
		try {
			customer = customerService.registerCustomerAccount(newCustomer);
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "register";
		}
		session.setAttribute("customer", customer);
		return "redirect:/Home";
	}
}
