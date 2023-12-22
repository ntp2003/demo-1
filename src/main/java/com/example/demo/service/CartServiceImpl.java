package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CartItem;
import com.example.demo.model.CustomerAccount;
import com.example.demo.model.Promotion;
import com.example.demo.model.QShoppingCart;
import com.example.demo.model.ShoppingCart;
import com.example.demo.model.StockDetails;
import com.example.demo.model.IdClass.ShoppingCartId;
import com.example.demo.repository.ShoppingCartRepo;
import com.example.demo.repository.StockDetailsRepo;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	ShoppingCartRepo shoppingCartRepo;
	
	@Autowired
	ProductsViewService productsViewService;
	@Autowired
	StockDetailsRepo stockDetailsRepo;
	
	@Override
	public boolean updateCart(int stockInventoryId, int quantity, int accountID) {
		ShoppingCart shoppingCart = new ShoppingCart();
		ShoppingCartId shoppingCartId =  new ShoppingCartId();
		Optional<StockDetails> stockDetails = stockDetailsRepo.findById(stockInventoryId);
		if(stockDetails.isEmpty())
			throw new IllegalArgumentException("Stock Inventory not found !!!");
		
		
		shoppingCartId.setCustomerAccount(new CustomerAccount());
		shoppingCartId.getCustomerAccount().setAccountId(accountID);
		shoppingCartId.setStockDetails(new StockDetails());
		shoppingCartId.getStockDetails().setStockInventoryId(stockInventoryId);

		
		Optional<ShoppingCart> scModel = shoppingCartRepo.findById(shoppingCartId);
		if(scModel.isEmpty()) {
			shoppingCart.setQuantity(quantity);
			shoppingCart.setShoppingCartId(shoppingCartId);
		}
		else {
			shoppingCart = scModel.get();
			shoppingCart.setQuantity(shoppingCart.getQuantity() + quantity);
		}
		try {
			if(stockDetails.get().getStock() < shoppingCart.getQuantity())
				throw new IllegalArgumentException("Stock is not enough !!!");
			shoppingCartRepo.save(shoppingCart);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCartItem(int stockInventoryId, int accountID) {
		ShoppingCartId shoppingCartId =  new ShoppingCartId();
		shoppingCartId.setCustomerAccount(new CustomerAccount());
		shoppingCartId.getCustomerAccount().setAccountId(accountID);
		shoppingCartId.setStockDetails(new StockDetails());
		shoppingCartId.getStockDetails().setStockInventoryId(stockInventoryId);
		try {
			shoppingCartRepo.deleteById(shoppingCartId);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public long countCartItem(int accountID) {
		return shoppingCartRepo.count(QShoppingCart.shoppingCart.shoppingCartId.customerAccount.accountId.eq(accountID));
	}

	@Override
	public List<CartItem> findCartItem(int accountID) {
		Optional<Promotion> promotion = productsViewService.findCurrentPromotion();
		return IterableUtils.toList(shoppingCartRepo
				.findAll(QShoppingCart.shoppingCart.shoppingCartId.customerAccount.accountId.eq(accountID)))
				.stream().map(i -> new CartItem(i, promotion)).toList();
	}

}
