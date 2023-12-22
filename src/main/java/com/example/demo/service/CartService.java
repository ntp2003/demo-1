package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CartItem;

@Service
public interface CartService {
	public boolean updateCart(int stockInventoryId, int quantity, int accountID);
	
	public boolean deleteCartItem(int stockInventoryId, int accountID);
	
	public long countCartItem(int accountID);
	
	public List<CartItem> findCartItem(int accountID);
}
