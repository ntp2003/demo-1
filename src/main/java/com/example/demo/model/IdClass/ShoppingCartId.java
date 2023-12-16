package com.example.demo.model.IdClass;

import java.io.Serializable;

import com.example.demo.model.CustomerAccount;
import com.example.demo.model.ProductCatalog;
import com.example.demo.model.Promotion;
import com.example.demo.model.StockDetails;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ShoppingCartId implements Serializable {
	@ManyToOne(optional=false)
    @JoinColumn(name="StockInventoryID", nullable=false)
    private StockDetails stockDetails;
	@ManyToOne(optional=false)
    @JoinColumn(name="AccountID", nullable=false)
    private CustomerAccount customerAccount;
}
