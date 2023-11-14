package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.LoginHistory;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LoginHistoryRepo extends JpaRepository<LoginHistory, Integer>{

}
