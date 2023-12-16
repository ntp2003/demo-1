package com.example.demo.model.IdClass;

import java.io.Serializable;

import com.example.demo.model.ProductCatalog;
import com.example.demo.model.Promotion;

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
public class PromotionDetailId implements Serializable {
	@ManyToOne(optional = false)
	@JoinColumn(name = "ProductID", nullable = false)
	private ProductCatalog productCatalog;
	@ManyToOne(optional = false)
	@JoinColumn(name = "PromotionID", nullable = false)
	private Promotion promotion;
}
