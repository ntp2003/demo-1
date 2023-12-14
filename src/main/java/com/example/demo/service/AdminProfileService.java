package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Admin;
import com.example.demo.security.userdetails.AdminUserDetails;

@Service
public interface AdminProfileService {
	public boolean chekcPassword(String password, Admin current);
	
	public AdminUserDetails updateInformation(Admin newInfo, String username);
	
	public AdminUserDetails updatePassword(String newPassword, String username);
}
