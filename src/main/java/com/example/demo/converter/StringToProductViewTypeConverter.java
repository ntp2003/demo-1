package com.example.demo.converter;

import org.springframework.core.convert.converter.Converter;

import com.example.demo.dto.ProductViewMode;

public class StringToProductViewTypeConverter implements Converter<String, ProductViewMode>{

	@Override
	public ProductViewMode convert(String source) {
		int input;
		
		try {
			input = Integer.parseInt(source);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		System.out.println(input);
		for (ProductViewMode item : ProductViewMode.values()) {
			if(input == item.ordinal()) {
				return item;
			}
		}
		return null;
	}
}
