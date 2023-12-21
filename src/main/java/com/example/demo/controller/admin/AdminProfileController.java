package com.example.demo.controller.admin;

import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Admin;
import com.example.demo.security.userdetails.AdminUserDetails;
import com.example.demo.service.AdminProfileService;

@Controller
@RequestMapping("/admin/Profile")
public class AdminProfileController {
	@Autowired
	AdminProfileService adminProfileService;
	
	@GetMapping("")
	public String loginAdminPage() {
		return "admin/profile";
	}
	
	@GetMapping("/check-password")
	@ResponseBody
	public ResponseEntity<Boolean> checkPassword(@RequestParam("oldPassword") String oldPassword, @AuthenticationPrincipal AdminUserDetails adminUserDetails){
		return ResponseEntity.ok(adminProfileService.chekcPassword(oldPassword, adminUserDetails.getAdmin()));
	}
	
	@PostMapping("/update-password")
	@ResponseBody
	public ResponseEntity<Void> updatePassword(@RequestBody Map<String, String> newPassword, @AuthenticationPrincipal AdminUserDetails adminUserDetails){
		try {
			AdminUserDetails updatedAdminUserDetails = adminProfileService.updatePassword(newPassword.get("newPassword"), adminUserDetails.getUsername());
			Authentication authentication = new UsernamePasswordAuthenticationToken(updatedAdminUserDetails, updatedAdminUserDetails.getPassword(), updatedAdminUserDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/update-info")
	@ResponseBody
	public ResponseEntity<Void> updateInformation(@RequestBody Admin newInfo, @AuthenticationPrincipal AdminUserDetails current){
		try {
			AdminUserDetails adminUserDetails = adminProfileService.updateInformation(newInfo, current.getUsername());
			Authentication authentication = new UsernamePasswordAuthenticationToken(adminUserDetails, adminUserDetails.getPassword(), adminUserDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
}
