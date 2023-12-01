package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.CustomerAccount;
import com.example.demo.service.CustomerService;

import jakarta.servlet.http.HttpSession;

@Controller
public class RegisterController {
	@Autowired
	public CustomerService customerService;
	
	@GetMapping("/Register")
	public ModelAndView RegisterPage() {
		return new ModelAndView("register", "newCustomer", new CustomerAccount());
	}

	@ResponseBody
	@PostMapping("/check-email-customer-exists")
	public boolean checkEmail(@RequestParam("email") String email ) {
		return customerService.emailNotExists(email);
	}
	
	@PostMapping("/Register")
	public String register(@ModelAttribute("newCustomer")CustomerAccount newCustomer) {
		CustomerAccount customer;
		try {
			customer = customerService.registerCustomerAccount(newCustomer);
		} catch (Exception e) {
			e.printStackTrace();
			return "register";
		}
		return "redirect:/Login";
	}
}
