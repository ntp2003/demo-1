package com.example.demo.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PromotionFilter {
	LocalDate fromDay;
	LocalDate toDay;
	String searchValue;
}
