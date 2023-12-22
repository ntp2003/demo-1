package com.example.demo.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.Admin;
import com.example.demo.dto.CustomerAccount;
import com.example.demo.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminRegisterController {
	@Autowired
	AdminService adminService;
	
	@GetMapping("/creator/Register")
	public ModelAndView adminRegisterPage() {
		return new ModelAndView("admin/register", "newAccount", new Admin());
	}
	
	@PostMapping("/creator/Register")
	@ResponseBody
	public ResponseEntity<Void> registerAdmin(@RequestBody Admin newAccount) {
		if(adminService.registerAdminAccount(newAccount))
			return new ResponseEntity<Void>(HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/check-email-exists")
	@ResponseBody
	public boolean checkEmail(@RequestParam("email") String email) {
		return adminService.emailNotExists(email);
	}
	
	@GetMapping("/check-phone-number-exists")
	@ResponseBody
	public boolean checkPhoneNUmber(@RequestParam("phoneNumber") String phoneNumber) {
		return adminService.phoneNumberNotExists(phoneNumber);
	}
	
	@GetMapping("/check-cccd-exists")
	@ResponseBody
	public boolean checkCCCD(@RequestParam("cccd") String cccd) {
		return adminService.cccdNotExists(cccd);
	}
	
	
	@GetMapping("/check-user-name-exists")
	@ResponseBody
	public boolean checkUserName(@RequestParam("username") String userName) {
		return adminService.userNameNotExists(userName);
	}
}
