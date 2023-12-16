package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ShoppingCart;
import com.example.demo.model.IdClass.ShoppingCartId;

@Repository
public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, ShoppingCartId>{
}
