package com.example.demo.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.AccountFilter;
import com.example.demo.dto.Admin;
import com.example.demo.dto.CustomerAccount;
import com.example.demo.service.AdminAccountManagementService;

@Controller
@RequestMapping("/admin/creator/Account")
public class AdminAccountManagementController {
	@Autowired
	AdminAccountManagementService accountManagementService;
	
	@GetMapping("")
	public String getAccountPage() {
		return "admin/account";
	}
	
	@PostMapping("/admin")
	@ResponseBody
	public ResponseEntity<Page<Admin>> getAdminAccount(
			@PageableDefault(page = 0, size = 10, sort = { "fullName"}, direction = Direction.ASC) Pageable pageable, 
			@RequestBody AccountFilter accountFilter){
		return ResponseEntity.ok(accountManagementService.findAdminAccount(accountFilter, pageable));
	}
	
	@PostMapping("/customer")
	@ResponseBody
	public ResponseEntity<Page<CustomerAccount>> getCustomerAccount(
			@PageableDefault(page = 0, size = 10, sort = { "customerName"}, direction = Direction.ASC) Pageable pageable, 
			@RequestBody AccountFilter accountFilter){
		return ResponseEntity.ok(accountManagementService.findCustomerAccount(accountFilter, pageable));
	}
	
	@DeleteMapping("/admin")
	@ResponseBody
	public ResponseEntity<Void> deleteAdminAccount(@RequestParam("userName") String userName){
		if(accountManagementService.deleteAdminAccount(userName)) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/customer")
	@ResponseBody
	public ResponseEntity<Void> deleteCustomerAccount(@RequestParam("accountId") int accountId){
		if(accountManagementService.deleteCustomerAccount(accountId)) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
}
