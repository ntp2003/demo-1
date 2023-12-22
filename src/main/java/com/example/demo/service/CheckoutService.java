package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CheckoutInfo;
import com.example.demo.security.userdetails.CustomerUserDetails;

@Service
public interface CheckoutService {
	public CheckoutInfo getCheckoutInfo(int accountId);
	
	public CustomerUserDetails getCheckout(CheckoutInfo checkoutInfo, int accountId);
}
