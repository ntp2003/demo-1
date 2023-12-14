package com.example.demo.model.IdClass;

import java.io.Serializable;

import com.example.demo.model.ProductLot;
import com.example.demo.model.ProductLotDetails;
import com.example.demo.model.StockDetails;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ProductLotDetailsId implements Serializable {
    @ManyToOne(optional=false)
    @JoinColumn(name="LotID", nullable=false)
    private ProductLot productLot;
    @ManyToOne(optional=false)
    @JoinColumn(name="StockInventoryID", nullable=false)
    private StockDetails stockDetails;
}
