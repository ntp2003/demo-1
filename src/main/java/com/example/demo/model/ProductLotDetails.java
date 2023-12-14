// Generated with g9.

package com.example.demo.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.example.demo.model.IdClass.ProductLotDetailsId;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class ProductLotDetails implements Serializable {
    @Column(name="Quantity", nullable=false, precision=10)
    private int quantity;
    @EmbeddedId
    private ProductLotDetailsId productLotDetailsId;
    public ProductLotDetails() {
        super();
    }
}
