package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CheckoutInfo;
import com.example.demo.dto.InvoiceStatus;
import com.example.demo.model.CustomerAccount;
import com.example.demo.model.InvoiceDetail;
import com.example.demo.model.Payment;
import com.example.demo.model.ProductCatalog;
import com.example.demo.model.Promotion;
import com.example.demo.model.PurchaseHistory;
import com.example.demo.model.PurchaseInvoice;
import com.example.demo.model.QShoppingCart;
import com.example.demo.model.ShoppingCart;
import com.example.demo.model.StockDetails;
import com.example.demo.model.IdClass.InvoiceDetailId;
import com.example.demo.model.IdClass.ShoppingCartId;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.repository.ElectronicWalletRepo;
import com.example.demo.repository.InvoiceDetailRepo;
import com.example.demo.repository.ProductCatalogRepo;
import com.example.demo.repository.PurchaseHistoryRepo;
import com.example.demo.repository.PurchaseInvoiceRepo;
import com.example.demo.repository.ShoppingCartRepo;
import com.example.demo.repository.StockDetailsRepo;
import com.example.demo.security.userdetails.CustomerUserDetails;

@Service
public class CheckoutServiceImpl implements CheckoutService{
	@Autowired
	ShoppingCartRepo shoppingCartRepo;
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	PurchaseInvoiceRepo purchaseInvoiceRepo;
	
	@Autowired
	PurchaseHistoryRepo purchaseHistoryRepo;
	
	@Autowired
	InvoiceDetailRepo invoiceDetailRepo;
	
	@Autowired
	ProductsViewService productsViewService;
	
	@Autowired
	ElectronicWalletRepo electronicWalletRepo;
	
	@Autowired
	StockDetailsRepo stockDetailsRepo;
	
	@Autowired
	ProductCatalogRepo productCatalogRepo;
	
	@Override
	public CheckoutInfo getCheckoutInfo(int accountId) {
		CustomerAccount customerAccount = getAccount(accountId);
		Iterable<ShoppingCart> cartItems = shoppingCartRepo.findAll(QShoppingCart.shoppingCart.shoppingCartId.customerAccount.eq(customerAccount));
		Optional<Promotion> promotion = productsViewService.findCurrentPromotion();
		
		return new CheckoutInfo(cartItems, promotion);
	}

	@Override
	public CustomerUserDetails getCheckout(CheckoutInfo checkoutInfo, int accountId) {
		CustomerAccount customerAccount = getAccount(accountId);
		CheckoutInfo current = getCheckoutInfo(accountId);
		PurchaseInvoice purchaseInvoice = new PurchaseInvoice();
		PurchaseHistory purchaseHistory = new PurchaseHistory();
		
		current.getItemDetails().forEach(i -> {
			checkoutInfo.getItemDetails().forEach(j ->{
				
				if(i.getStockInventoryId() == j.getStockInventoryId() && (Math.abs(i.getPrice().subtract(j.getPrice()).doubleValue()) > 1e-4 || 
						Math.abs(i.getDiscount().subtract(j.getDiscount()).doubleValue()) > 1e-4)) {
					throw new RuntimeException("Infomation is updated. Please reload page !!!");
				}
			});
		});
		if(checkoutInfo.getPaymentMethod() == 2) {
			if(checkoutInfo.getTotal().compareTo(customerAccount.getElectronicWallet().getBalance()) == 1) {
				throw new IllegalArgumentException("Balance is not enough");
			}
			customerAccount.getElectronicWallet().setBalance(customerAccount.getElectronicWallet().getBalance().subtract(checkoutInfo.getTotal()));
			electronicWalletRepo.save(customerAccount.getElectronicWallet());
		}
		purchaseInvoice.setCreatedTime(LocalDateTime.now());
		purchaseInvoice.setAddress(checkoutInfo.getAddress());
		purchaseInvoice.setPhoneNumber(checkoutInfo.getPhoneNumber());
		purchaseInvoice.setOriginalPrice(current.getOriginalPrice());
		purchaseInvoice.setDiscount(current.getDiscount());
		purchaseInvoice.setShippingFee(checkoutInfo.getShippingFee());
		purchaseInvoice.setTotal(current.getTotal().add(checkoutInfo.getShippingFee()));
		purchaseInvoice.setPayment(new Payment());
		purchaseInvoice.getPayment().setPaymentMethod(checkoutInfo.getPaymentMethod());
		PurchaseInvoice newPurchaseInvoice = purchaseInvoiceRepo.save(purchaseInvoice);
		
		current.getItemDetails().forEach(i -> {
			StockDetails stockDetails = stockDetailsRepo.findById(i.getStockInventoryId()).get();
			ProductCatalog productCatalog = productCatalogRepo.findById(stockDetails.getProductCategory().getProductCatalog().getProductId()).get();
			InvoiceDetail invoiceDetail = new InvoiceDetail();
			invoiceDetail.setInvoiceDetailId(new InvoiceDetailId());
			invoiceDetail.getInvoiceDetailId().setStockDetails(stockDetails);
			invoiceDetail.getInvoiceDetailId().setPurchaseInvoice(newPurchaseInvoice);
			invoiceDetail.setQuantity(i.getQuantity());
			invoiceDetail.setOriginalPrice(i.getPrice());
			invoiceDetail.setDiscount(i.getDiscount());
			invoiceDetailRepo.save(invoiceDetail);
			productCatalog.setPurchaseCount(productCatalog.getPurchaseCount() + i.getQuantity());
			productCatalogRepo.save(productCatalog);
			stockDetails.setStock(stockDetails.getStock() - i.getQuantity());
			ShoppingCartId shoppingCartId = new ShoppingCartId();
			shoppingCartId.setCustomerAccount(customerAccount);
			shoppingCartId.setStockDetails(stockDetails);
			shoppingCartRepo.deleteById(shoppingCartId);
			
		});
		
		purchaseHistory.setCustomerAccount(customerAccount);
		purchaseHistory.setPurchaseInvoice(newPurchaseInvoice);
		purchaseHistory.setStatus(InvoiceStatus.NOTCONFIRMED);
		purchaseHistoryRepo.save(purchaseHistory);
		
		if(checkoutInfo.getPaymentMethod() == 2) {
			return customerRepo.findById(accountId).map(CustomerUserDetails::new)
					.orElseThrow(() -> new UsernameNotFoundException("Cutomer not found !!!"));
		}
		return null;
	}
	
	private CustomerAccount getAccount(int accountId) {
		Optional<CustomerAccount> customer = customerRepo.findById(accountId);
		if(customer.isEmpty())
			throw new UsernameNotFoundException("Cutomer not found !!!");
		return customer.get();
	}
}
