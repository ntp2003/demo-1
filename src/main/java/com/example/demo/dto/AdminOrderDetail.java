package com.example.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;

import org.eclipse.tags.shaded.org.apache.bcel.generic.NEW;

import com.example.demo.model.PurchaseHistory;
import com.example.demo.model.PurchaseInvoice;

import lombok.Data;

@Data
public class AdminOrderDetail extends CheckoutInfo{
	private int invoiceId;
	private String status;
	private int accountId;
	private String customerName;
	private String payment;
	
	public AdminOrderDetail(PurchaseHistory purchaseHistory) {
		PurchaseInvoice purchaseInvoice = purchaseHistory.getPurchaseInvoice();
		
		invoiceId = purchaseInvoice.getInvoiceId();
		status = purchaseHistory.getStatus();
		accountId = purchaseHistory.getCustomerAccount().getAccountId();
		customerName = purchaseHistory.getCustomerAccount().getCustomerName();
		address = purchaseInvoice.getAddress();
		phoneNumber = purchaseInvoice.getPhoneNumber();
		originalPrice = purchaseInvoice.getOriginalPrice();
		discount = purchaseInvoice.getDiscount();
		shippingFee = purchaseInvoice.getShippingFee();
		total = purchaseInvoice.getTotal();
		payment = purchaseInvoice.getPayment().getDescription();
		itemDetails = purchaseInvoice.getInvoiceDetail().stream().map(i -> new CheckoutItemDetail(i)).toList();
	}
}
