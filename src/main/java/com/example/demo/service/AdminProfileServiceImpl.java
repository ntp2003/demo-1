package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Admin;
import com.example.demo.repository.AdminRepo;
import com.example.demo.security.userdetails.AdminUserDetails;

@Service
public class AdminProfileServiceImpl implements AdminProfileService {
	@Autowired
	AdminRepo adminRepo;

	@Autowired
	@Qualifier("adminPasswordEncoder")
	PasswordEncoder adminPasswordEncoder;

	@Override
	public boolean chekcPassword(String password, Admin current) {
		return adminPasswordEncoder.encode(password).equals(current.getPassword());
	}

	@Override
	public AdminUserDetails updateInformation(Admin newInfo, String username) {
		return adminRepo.findById(username).map(i -> {
			i.setEmail(newInfo.getEmail());
			i.setFullName(newInfo.getFirstName() + " " + newInfo.getLastName());
			i.setPhoneNumber(newInfo.getPhoneNumber());
			return new AdminUserDetails(adminRepo.save(i));
		}).orElseThrow(() -> new UsernameNotFoundException("user not found: " + username));
	}

	@Override
	public AdminUserDetails updatePassword(String newPassword, String username) {
		return adminRepo.findById(username).map(i -> {
			i.setPassword(newPassword);
			return new AdminUserDetails(adminRepo.save(i));
		}).orElseThrow(() -> new UsernameNotFoundException("user not found: " + username));
	}

}
