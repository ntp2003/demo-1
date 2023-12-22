package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CountStatistic;
import com.example.demo.dto.Feedback;
import com.example.demo.dto.OrderView;

@Service
public interface OrderHistoryService {
	public List<OrderView> findOrderView(String status, Optional<Integer> fromDay, int accountId);
	
	public List<CountStatistic> orderStatusStatistic(int accountId);
	
	public void sendFeedback(Feedback feedback);
}
