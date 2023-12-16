// Generated with g9.

package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import com.example.demo.model.IdClass.PromotionDetailId;

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
public class PromotionDetail implements Serializable {
    @Column(name="DiscountRate",  nullable=false, precision=3)
    private short discountRate;
    @EmbeddedId
    private PromotionDetailId promotionDetailId; 
    public PromotionDetail() {
        super();
    }
}
