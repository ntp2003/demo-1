package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

public class AccountFilter {
	@Getter
	@Setter
	private String searchValue;
	private SearchOption searchOption;
	
	public SearchOption getSearchOption() {
		return searchOption;
	}
	
	public void setSearchOption(int searchOption) {
		this.searchOption = SearchOption.fromInt(searchOption);
	}
	
	public enum SearchOption{
		NAME, PHONENUMBER, EMAIL, CCCD, USERNAME;
		
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
