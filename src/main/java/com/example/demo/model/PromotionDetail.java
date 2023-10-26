// Generated with g9.

package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(PromotionDetail.PromotionDetailId.class)
public class PromotionDetail implements Serializable {

    /**
     * IdClass for primary key when using JPA annotations
     */
    public class PromotionDetailId implements Serializable {
        Promotion promotion;
        ProductCatalog productCatalog;
    }

    /** Primary key. */
    protected static final String PK = "PromotionDetailPkPromotionDetail";

    @Column(name="DiscountRate", precision=18)
    private BigDecimal discountRate;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="ProductID", nullable=false)
    private ProductCatalog productCatalog;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="PromotionID", nullable=false)
    private Promotion promotion;

    /** Default constructor. */
    public PromotionDetail() {
        super();
    }

    /**
     * Access method for discountRate.
     *
     * @return the current value of discountRate
     */
    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    /**
     * Setter method for discountRate.
     *
     * @param aDiscountRate the new value for discountRate
     */
    public void setDiscountRate(BigDecimal aDiscountRate) {
        discountRate = aDiscountRate;
    }

    /**
     * Access method for productCatalog.
     *
     * @return the current value of productCatalog
     */
    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    /**
     * Setter method for productCatalog.
     *
     * @param aProductCatalog the new value for productCatalog
     */
    public void setProductCatalog(ProductCatalog aProductCatalog) {
        productCatalog = aProductCatalog;
    }

    /**
     * Access method for promotion.
     *
     * @return the current value of promotion
     */
    public Promotion getPromotion() {
        return promotion;
    }

    /**
     * Setter method for promotion.
     *
     * @param aPromotion the new value for promotion
     */
    public void setPromotion(Promotion aPromotion) {
        promotion = aPromotion;
    }

    /** Temporary value holder for group key fragment promotionPromotionId */
    private transient int tempPromotionPromotionId;

    /**
     * Gets the key fragment promotionId for member promotion.
     * If this.promotion is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setPromotionPromotionId.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see Promotion
     */
    public int getPromotionPromotionId() {
        return (getPromotion() == null ? tempPromotionPromotionId : getPromotion().getPromotionId());
    }

    /**
     * Sets the key fragment promotionId from member promotion.
     * If this.promotion is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getPromotionPromotionId.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aPromotionId New value for the key fragment
     * @see Promotion
     */
    public void setPromotionPromotionId(int aPromotionId) {
        if (getPromotion() == null) {
            tempPromotionPromotionId = aPromotionId;
        } else {
            getPromotion().setPromotionId(aPromotionId);
        }
    }

    /** Temporary value holder for group key fragment productCatalogProductId */
    private transient short tempProductCatalogProductId;

    /**
     * Gets the key fragment productId for member productCatalog.
     * If this.productCatalog is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setProductCatalogProductId.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see ProductCatalog
     */
    public short getProductCatalogProductId() {
        return (getProductCatalog() == null ? tempProductCatalogProductId : getProductCatalog().getProductId());
    }

    /**
     * Sets the key fragment productId from member productCatalog.
     * If this.productCatalog is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getProductCatalogProductId.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aProductId New value for the key fragment
     * @see ProductCatalog
     */
    public void setProductCatalogProductId(short aProductId) {
        if (getProductCatalog() == null) {
            tempProductCatalogProductId = aProductId;
        } else {
            getProductCatalog().setProductId(aProductId);
        }
    }

    /**
     * Compares the key for this instance with another PromotionDetail.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class PromotionDetail and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof PromotionDetail)) {
            return false;
        }
        PromotionDetail that = (PromotionDetail) other;
        if (this.getPromotionPromotionId() != that.getPromotionPromotionId()) {
            return false;
        }
        if (this.getProductCatalogProductId() != that.getProductCatalogProductId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another PromotionDetail.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PromotionDetail)) return false;
        return this.equalKeys(other) && ((PromotionDetail)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getPromotionPromotionId();
        result = 37*result + i;
        i = getProductCatalogProductId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[PromotionDetail |");
        sb.append(" promotionPromotionId=").append(getPromotionPromotionId());
        sb.append(" productCatalogProductId=").append(getProductCatalogProductId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("promotionPromotionId", Integer.valueOf(getPromotionPromotionId()));
        ret.put("productCatalogProductId", Short.valueOf(getProductCatalogProductId()));
        return ret;
    }

}
