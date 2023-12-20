package com.example.demo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import lombok.Data;

@Data
public class ProductFilter implements Serializable{
	List<String> colors;
	List<String> brands;
	List<Short> productTypes;
	String specialType;
	Optional<BigDecimal> minPrice;
	Optional<BigDecimal> maxPrice;
}
