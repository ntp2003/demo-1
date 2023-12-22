package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AdminOrderDetail;
import com.example.demo.dto.AdminOrderFilter;
import com.example.demo.dto.CountStatistic;
import com.example.demo.dto.PurchaseInvoice;

@Service
public interface AdminOrderService {
	public Page<PurchaseInvoice> getPurchaseInvoicePage(AdminOrderFilter filter, Pageable pageable);
	
	public PurchaseInvoice updateStatus(int purchaseHistoryId, String updateStatus);
	
	public AdminOrderDetail getAdminOrderDetail(int purchaseHistoryId);
	
	public List<CountStatistic> orderStatusStatistic();
}
