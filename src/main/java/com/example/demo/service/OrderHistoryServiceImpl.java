package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CountStatistic;
import com.example.demo.dto.Feedback;
import com.example.demo.dto.OrderView;
import com.example.demo.model.PurchaseHistory;
import com.example.demo.model.QPurchaseHistory;
import com.example.demo.repository.FeedbackRepo;
import com.example.demo.repository.PurchaseHistoryRepo;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {
	@Autowired
	PurchaseHistoryRepo purchaseHistoryRepo;
	
	@Autowired
	FeedbackRepo feedbackRepo;

	@Autowired
	JPAQueryFactory jpaQueryFactory;

	@Override
	public List<OrderView> findOrderView(String status, Optional<Integer> fromDay, int accountId) {
		QPurchaseHistory qPurchaseHistory = QPurchaseHistory.purchaseHistory;
		BooleanExpression predicate = qPurchaseHistory.customerAccount.accountId.eq(accountId);

		if (status != null && !status.isBlank())
			predicate = predicate.and(qPurchaseHistory.status.eq(status));
		if (fromDay.isPresent())
			predicate = predicate.and(
					qPurchaseHistory.purchaseInvoice.createdTime.goe(LocalDateTime.now().minusDays(fromDay.get())));

		return IterableUtils.toList(purchaseHistoryRepo.findAll(predicate)).stream().map(OrderView::new).toList();
	}

	@Override
	public List<CountStatistic> orderStatusStatistic(int accountId) {
		QPurchaseHistory qPurchaseHistory = QPurchaseHistory.purchaseHistory;

		return jpaQueryFactory.from(qPurchaseHistory).where(qPurchaseHistory.customerAccount.accountId.eq(accountId)).groupBy(qPurchaseHistory.status)
				.select(qPurchaseHistory.status, qPurchaseHistory.purchaseId.count()).fetch().stream()
				.map(i -> new CountStatistic(i.get(0, String.class), i.get(1, Long.class))).toList();
	}

	@Override
	public void sendFeedback(Feedback feedback) {
		feedbackRepo.save(feedback.toModel());
	}

}
