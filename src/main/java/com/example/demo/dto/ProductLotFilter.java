package com.example.demo.dto;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductLotFilter{
	private LocalDate fromDate;
	private LocalDate toDate;
	private String searchValue;
	private SearchOption searchOption;
	
	public SearchOption getSearchOption() {
		return searchOption;
	}
	
	public void setSearchOption(int searchOption) {
		this.searchOption = SearchOption.fromInt(searchOption);
	}
	
	public enum SearchOption{
		NAME, PHONENUMBER, EMAIL;
		
		public static SearchOption fromInt(int input) {
			for (SearchOption item : SearchOption.values()) {
				if(input == item.ordinal()) {
					return item;
				}
			}
			return null;
		}
	}
}
