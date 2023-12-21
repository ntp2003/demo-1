package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerAccount;
import com.example.demo.security.userdetails.CustomerUserDetails;

@Service
public interface CustomerProfileService {
	public boolean chekcPassword(String password, CustomerAccount current);

	public CustomerUserDetails updateInformation(CustomerAccount newInfo, int accountId);

	public CustomerUserDetails updatePassword(String newPassword, int accountId);
	
	public CustomerUserDetails updateAvatar(String avatar, int accountId);
	
	public CustomerUserDetails linkElectronicWallet(int walletId, String verificationCodes, int accountId);
	
	public CustomerUserDetails unlinkElectronicWallet(int accountId);
}
