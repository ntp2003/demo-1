package com.example.demo.model.IdClass;

import java.io.Serializable;

import com.example.demo.model.ProductLot;
import com.example.demo.model.PurchaseInvoice;
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
public class InvoiceDetailId implements Serializable {
	@ManyToOne(optional=false)
    @JoinColumn(name="InvoiceID", nullable=false)
    private PurchaseInvoice purchaseInvoice;
	@ManyToOne(optional=false)
    @JoinColumn(name="StockInventoryID", nullable=false)
    private StockDetails stockDetails;
}
