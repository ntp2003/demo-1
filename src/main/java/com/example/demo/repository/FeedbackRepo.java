package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ElectronicWallet;
import com.example.demo.model.Feedback;
import com.example.demo.model.IdClass.FeedbackId;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, FeedbackId>, QuerydslPredicateExecutor<Feedback>{

}
