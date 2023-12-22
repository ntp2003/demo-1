package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminOrderFilter {
	LocalDateTime fromDay;
	LocalDateTime toDay;
	String status;
}
