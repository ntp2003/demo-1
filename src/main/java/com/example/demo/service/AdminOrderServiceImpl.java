package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.eclipse.tags.shaded.org.apache.bcel.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AdminOrderDetail;
import com.example.demo.dto.AdminOrderFilter;
import com.example.demo.dto.CountStatistic;
import com.example.demo.dto.InvoiceStatus;
import com.example.demo.dto.PurchaseInvoice;
import com.example.demo.model.ElectronicWallet;
import com.example.demo.model.PurchaseHistory;
import com.example.demo.model.QPurchaseHistory;
import com.example.demo.model.QPurchaseInvoice;
import com.example.demo.repository.ElectronicWalletRepo;
import com.example.demo.repository.PurchaseHistoryRepo;
import com.example.demo.repository.PurchaseInvoiceRepo;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
public class AdminOrderServiceImpl implements AdminOrderService{
	@Autowired
	PurchaseInvoiceRepo purchaseInvoiceRepo;
	
	@Autowired
	PurchaseHistoryRepo purchaseHistoryRepo;
	
	@Autowired
	ElectronicWalletRepo electronicWalletRepo;
	
	@Autowired
	JPAQueryFactory jpaQueryFactory;
	
	@Override
	public Page<PurchaseInvoice> getPurchaseInvoicePage(AdminOrderFilter filter, Pageable pageable) {
		QPurchaseInvoice qPurchaseInvoice = QPurchaseInvoice.purchaseInvoice;
		BooleanExpression predicate = Expressions.asBoolean(true).isTrue();
		
		if(filter.getFromDay() != null)
			predicate = predicate.and(qPurchaseInvoice.createdTime.goe(filter.getFromDay()));
		if(filter.getToDay() != null)
			predicate = predicate.and(qPurchaseInvoice.createdTime.loe(filter.getToDay().plusDays(1)));
		if(filter.getStatus() != null && !filter.getStatus().isBlank())
			predicate = predicate.and(qPurchaseInvoice.purchaseHistory.any().status.eq(filter.getStatus()));
			
		return purchaseInvoiceRepo.findAll(predicate, pageable).map(PurchaseInvoice::new);
	}

	@Override
	public PurchaseInvoice updateStatus(int purchaseHistoryId, String updateStatus) {
		PurchaseHistory purchaseHistory = purchaseHistoryRepo.findById(purchaseHistoryId).get();
		for (String i : InvoiceStatus.nextPossibleStatus(purchaseHistory.getStatus())) {
			if(updateStatus.equals(i)) {
				com.example.demo.model.PurchaseInvoice purchaseInvoice = null;
				purchaseHistory.setStatus(updateStatus);
				if(updateStatus.equals(InvoiceStatus.CANCELLED)) {
					if(purchaseHistory.getPurchaseInvoice().getPayment().getPaymentMethod() == 2) {
						ElectronicWallet electronicWallet = purchaseHistory.getCustomerAccount().getElectronicWallet();
						electronicWallet.setBalance(electronicWallet.getBalance().add(purchaseHistory.getPurchaseInvoice().getTotal()));
					}
				}
				
				PurchaseHistory updated = purchaseHistoryRepo.save(purchaseHistory);
				
				if(updateStatus.equals(InvoiceStatus.COMPLETED)) {
					updated.getPurchaseInvoice().setCompletedTime(LocalDateTime.now());
					purchaseInvoice = purchaseInvoiceRepo.save(updated.getPurchaseInvoice());
				}
				else {
					purchaseInvoice = updated.getPurchaseInvoice();
				}
				
				return new PurchaseInvoice(purchaseInvoice);
			}
		}
		throw new IllegalArgumentException("Update status failed !!!");
	}

	@Override
	public AdminOrderDetail getAdminOrderDetail(int purchaseHistoryId) {
		return purchaseHistoryRepo.findById(purchaseHistoryId).map(AdminOrderDetail::new)
				.orElseThrow(() -> new IllegalArgumentException("Not found invoice in history !!!"));
	}

	@Override
	public List<CountStatistic> orderStatusStatistic() {
		QPurchaseHistory qPurchaseHistory = QPurchaseHistory.purchaseHistory;
		
		return jpaQueryFactory.from(qPurchaseHistory)
				.groupBy(qPurchaseHistory.status)
				.select(qPurchaseHistory.status, qPurchaseHistory.purchaseId.count())
				.fetch().stream().map(i -> new CountStatistic(i.get(0, String.class), i.get(1, Long.class))).toList();
	}

}
