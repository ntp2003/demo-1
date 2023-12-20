package com.example.demo.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.example.demo.model.IdClass.ShoppingCartId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ShoppingCart implements Serializable {
    @Column(name="Quantity", nullable=false, precision=10)
    private int quantity;
    @EmbeddedId
    private ShoppingCartId shoppingCartId;
    public ShoppingCart() {
        super();
    }
}
