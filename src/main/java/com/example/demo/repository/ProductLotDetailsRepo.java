package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ProductLot;
import com.example.demo.model.ProductLotDetails;
import com.example.demo.model.IdClass.ProductLotDetailsId;

@Repository
public interface ProductLotDetailsRepo extends CrudRepository<ProductLotDetails, ProductLotDetailsId>{
	List<ProductLotDetails> findByProductLotDetailsIdProductLot(ProductLot productLot);
}
