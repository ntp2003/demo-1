package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.ProductLot;
import com.example.demo.model.ProductLotDetails;
import com.example.demo.model.IdClass.ProductLotDetailsId;

public interface ProductLotDetailsRepo extends CrudRepository<ProductLotDetails, ProductLotDetailsId>{
	List<ProductLotDetails> findByProductLotDetailsIdProductLot(ProductLot productLot);
}
