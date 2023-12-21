package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Admin;
import com.example.demo.dto.CustomerAccount;
import com.example.demo.security.userdetails.AdminUserDetails;
import com.example.demo.security.userdetails.CustomerUserDetails;
import com.example.demo.service.CustomerProfileService;

@Controller
@RequestMapping("/customer/Profile")
public class CustomerProfileController {
	@Autowired
	CustomerProfileService customerProfileService;
	
	@GetMapping("")
	public String getProfilePage() {
		return "profile";
	}
	
	@GetMapping("/check-password")
	@ResponseBody
	public ResponseEntity<Boolean> checkPassword(@RequestParam("oldPassword") String oldPassword, @AuthenticationPrincipal CustomerUserDetails customerUserDetails){
		return ResponseEntity.ok(customerProfileService.chekcPassword(oldPassword, customerUserDetails.getCustomerAccount()));
	}
	
	@PostMapping("/update-info")
	@ResponseBody
	public ResponseEntity<Void> updateInformation(@RequestBody CustomerAccount newInfo, @AuthenticationPrincipal CustomerUserDetails current){
		try {
			CustomerUserDetails customerUserDetails = customerProfileService.updateInformation(newInfo, current.getCustomerAccount().getAccountId());
			Authentication authentication = new UsernamePasswordAuthenticationToken(customerUserDetails,customerUserDetails.getPassword(), customerUserDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update-password")
	@ResponseBody
	public ResponseEntity<Void> updateInformation(@RequestParam("newPassword") String newPassword, @AuthenticationPrincipal CustomerUserDetails current){
		try {
			CustomerUserDetails customerUserDetails = customerProfileService.updatePassword(newPassword, current.getCustomerAccount().getAccountId());
			Authentication authentication = new UsernamePasswordAuthenticationToken(customerUserDetails,customerUserDetails.getPassword(), customerUserDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update-avatar")
	@ResponseBody
	public ResponseEntity<Void> updateAvatar(@RequestParam("avatar") String avatar, @AuthenticationPrincipal CustomerUserDetails current){
		try {
			CustomerUserDetails customerUserDetails = customerProfileService.updateAvatar(avatar, current.getCustomerAccount().getAccountId());
			Authentication authentication = new UsernamePasswordAuthenticationToken(customerUserDetails,customerUserDetails.getPassword(), customerUserDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/link-wallet")
	@ResponseBody
	public ResponseEntity<Void> linkElectronicWallet(@RequestParam("walletId") int walletId,
			@RequestParam("verificationCodes") String verificationCodes, @AuthenticationPrincipal CustomerUserDetails current){
		try {
			CustomerUserDetails customerUserDetails = customerProfileService
					.linkElectronicWallet(walletId, verificationCodes, current.getCustomerAccount().getAccountId());
			Authentication authentication = new UsernamePasswordAuthenticationToken(customerUserDetails,customerUserDetails.getPassword(), customerUserDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/unlink-wallet")
	@ResponseBody
	public ResponseEntity<Void> unlinkElectronicWallet(@AuthenticationPrincipal CustomerUserDetails current){
		try {
			CustomerUserDetails customerUserDetails = customerProfileService.unlinkElectronicWallet(current.getCustomerAccount().getAccountId());
			Authentication authentication = new UsernamePasswordAuthenticationToken(customerUserDetails,customerUserDetails.getPassword(), customerUserDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
}
