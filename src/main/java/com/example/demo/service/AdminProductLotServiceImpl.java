package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Admin;
import com.example.demo.dto.ProductLot;
import com.example.demo.dto.ProductLotCatalogOption;
import com.example.demo.dto.ProductLotFilter;
import com.example.demo.dto.ProductLotImportItem;
import com.example.demo.dto.ProductLotImportItemDetails;
import com.example.demo.model.ProductLotDetails;
import com.example.demo.model.QProductLot;
import com.example.demo.model.StockDetails;
import com.example.demo.model.IdClass.ProductLotDetailsId;
import com.example.demo.repository.ProductCatalogRepo;
import com.example.demo.repository.ProductLotDetailsRepo;
import com.example.demo.repository.ProductLotRepo;
import com.example.demo.repository.StockDetailsRepo;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

@Service
public class AdminProductLotServiceImpl implements AdminProductLotService{
	@Autowired
	ProductLotRepo productLotRepo;
	
	@Autowired
	ProductCatalogRepo productCatalogRepo;
	
	@Autowired
	ProductLotDetailsRepo productLotDetailsRepo;
	
	@Autowired
	StockDetailsRepo stockDetailsRepo;
	
	@Override
	public Page<ProductLot> findProductLots(ProductLotFilter productLotFilter, Pageable pageable) {
		QProductLot qProductLot = QProductLot.productLot;
		BooleanExpression predicate = Expressions.asBoolean(true).isTrue();
		
		if(productLotFilter.getFromDate() != null)
			predicate = predicate.and(qProductLot.importDate.goe(productLotFilter.getFromDate()));
		if(productLotFilter.getToDate() != null)
			predicate = predicate.and(qProductLot.importDate.loe(productLotFilter.getToDate()));
		if(productLotFilter.getSearchValue() != null && !productLotFilter.getSearchValue().isBlank()) {
			switch (productLotFilter.getSearchOption()) {
			case NAME:
				predicate = predicate.and(qProductLot.admin.fullName.contains(productLotFilter.getSearchValue()));
				break;
			case PHONENUMBER:
				predicate = predicate.and(qProductLot.admin.phoneNumber.contains(productLotFilter.getSearchValue()));
				break;
			case EMAIL:
				predicate = predicate.and(qProductLot.admin.email.contains(productLotFilter.getSearchValue()));
				break;
			default:
				throw new IllegalStateException("Unknown argument value !!!");
			}
		}
		
		return productLotRepo.findAll(predicate, pageable).map(i -> new ProductLot(i));
	}

	@Override
	public ProductLotCatalogOption findOptionForProduct(short productId) {
		return productCatalogRepo.findById(productId).map(ProductLotCatalogOption::new)
				.orElseThrow(() -> new NotFoundException("Product catalog not found"));
	}

	@Override
	public List<ProductLotImportItemDetails> findLotImportItemDetails(int lotId) {
		com.example.demo.model.ProductLot pLot = new com.example.demo.model.ProductLot();
		pLot.setLotId(lotId);
		return productLotDetailsRepo.findByProductLotDetailsIdProductLot(pLot).stream().map(ProductLotImportItemDetails::new).toList();
	}

	@Override
	public boolean importProductLot(Admin admin, List<ProductLotImportItem> pImportItems) {
		com.example.demo.model.ProductLot productLot;
		
		try {
			com.example.demo.model.ProductLot pLot = new com.example.demo.model.ProductLot();
			pLot.setAdmin(admin.toModel());
			pLot.setImportDate(LocalDate.now());
			productLot = productLotRepo.save(pLot);
		} catch (DataAccessException dae) {
			dae.printStackTrace();
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		for (ProductLotImportItem productLotImportItem : pImportItems) {
			ProductLotDetails productLotDetails = new ProductLotDetails();
			StockDetails stockDetails = new StockDetails();
			stockDetails.setStockInventoryId(productLotImportItem.getStockInventoryID());
			ProductLotDetailsId productLotDetailsId = new ProductLotDetailsId(productLot, stockDetails);
			productLotDetails.setProductLotDetailsId(productLotDetailsId);
			productLotDetails.setQuantity(productLotImportItem.getQuantity());
			
			try {
				ProductLotDetails pLotDetails = productLotDetailsRepo.save(productLotDetails);
				StockDetails sDetails = stockDetailsRepo.findById(pLotDetails.getProductLotDetailsId().getStockDetails().getStockInventoryId()).get();
				
				sDetails.setStock(stockDetails.getStock() + pLotDetails.getQuantity());
				stockDetailsRepo.save(sDetails);
			} catch (DataAccessException dae) {
				dae.printStackTrace();
				return false;
			}
			catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		return true;
	}

}
