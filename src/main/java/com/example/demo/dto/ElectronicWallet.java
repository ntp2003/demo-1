package com.example.demo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ElectronicWallet implements Serializable {
	private int walletId;
    private BigDecimal balance;
    
    public ElectronicWallet(com.example.demo.model.ElectronicWallet electronicWallet) {
    	this.walletId = electronicWallet.getWalletId();
    	this.balance = electronicWallet.getBalance();
    }
    
    public com.example.demo.model.ElectronicWallet toModel(){
    	com.example.demo.model.ElectronicWallet electronicWallet = new com.example.demo.model.ElectronicWallet();
    	
    	electronicWallet.setWalletId(walletId);
    	electronicWallet.setBalance(balance);
    	
    	return electronicWallet;
    }
}
