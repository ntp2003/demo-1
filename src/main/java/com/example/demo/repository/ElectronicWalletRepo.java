package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ElectronicWallet;

public interface ElectronicWalletRepo extends JpaRepository<ElectronicWallet, Integer>{

}
