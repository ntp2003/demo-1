package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Admin;
import com.example.demo.dto.ProductLot;
import com.example.demo.dto.ProductLotCatalogOption;
import com.example.demo.dto.ProductLotFilter;
import com.example.demo.dto.ProductLotImportItem;
import com.example.demo.dto.ProductLotImportItemDetails;

@Service
public interface AdminProductLotService {
	public Page<ProductLot> findProductLots(ProductLotFilter productLotFilter, Pageable pageable);
	
	public ProductLotCatalogOption findOptionForProduct(short productId);
	
	public List<ProductLotImportItemDetails> findLotImportItemDetails(int lotId);
	
	public boolean importProductLot(Admin admin, List<ProductLotImportItem> pImportItems);
}
