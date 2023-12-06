// Generated with g9.

package com.example.demo.dto;

import java.io.Serializable;
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
public class ProductType implements Serializable {
	private short productTypeId;
	private String typeName;
	
	public ProductType(com.example.demo.model.ProductType productType) {
		this.productTypeId = productType.getProductTypeId();
		this.typeName = productType.getTypeName();
	}
	
	public com.example.demo.model.ProductType toModel(){
		com.example.demo.model.ProductType pType = new com.example.demo.model.ProductType();
		
		pType.setProductTypeId(productTypeId);
		pType.setTypeName(typeName);
		
		return pType;
	}
}
