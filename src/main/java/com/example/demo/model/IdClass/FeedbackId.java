package com.example.demo.model.IdClass;

import java.io.Serializable;

import com.example.demo.model.PurchaseHistory;
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
public class FeedbackId implements Serializable {
	@ManyToOne(optional=false)
    @JoinColumn(name="PurchaseID", nullable=false)
    private PurchaseHistory purchaseHistory;
    @ManyToOne(optional=false)
    @JoinColumn(name="StockInventoryID", nullable=false)
    private StockDetails stockDetails;
}
