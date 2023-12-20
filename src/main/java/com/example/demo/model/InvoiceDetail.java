// Generated with g9.

package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import com.example.demo.model.IdClass.InvoiceDetailId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class InvoiceDetail implements Serializable {
    @Column(name="Quantity", nullable=false, precision=10)
    private int quantity;
    @Column(name="OriginalPrice", nullable=false, precision=19, scale=4)
    private BigDecimal originalPrice;
    @Column(name="Discount", nullable=false, precision=19, scale=4)
    private BigDecimal discount;
    @EmbeddedId
    private InvoiceDetailId invoiceDetailId;
    public InvoiceDetail() {
    	super();
    }
}
