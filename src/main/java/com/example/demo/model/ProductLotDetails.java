// Generated with g9.

package com.example.demo.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(ProductLotDetails.ProductLotDetailsId.class)
public class ProductLotDetails implements Serializable {

    /**
     * IdClass for primary key when using JPA annotations
     */
    public class ProductLotDetailsId implements Serializable {
        ProductCategory productCategory;
        ProductLot productLot;
    }

    /** Primary key. */
    protected static final String PK = "ProductLotDetailsPkProductLotDetails";

    @Column(name="Quantity", nullable=false, precision=10)
    private int quantity;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="LotID", nullable=false)
    private ProductLot productLot;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="ProductCategoryID", nullable=false)
    private ProductCategory productCategory;

    /** Default constructor. */
    public ProductLotDetails() {
        super();
    }

    /**
     * Access method for quantity.
     *
     * @return the current value of quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter method for quantity.
     *
     * @param aQuantity the new value for quantity
     */
    public void setQuantity(int aQuantity) {
        quantity = aQuantity;
    }

    /**
     * Access method for productLot.
     *
     * @return the current value of productLot
     */
    public ProductLot getProductLot() {
        return productLot;
    }

    /**
     * Setter method for productLot.
     *
     * @param aProductLot the new value for productLot
     */
    public void setProductLot(ProductLot aProductLot) {
        productLot = aProductLot;
    }

    /**
     * Access method for productCategory.
     *
     * @return the current value of productCategory
     */
    public ProductCategory getProductCategory() {
        return productCategory;
    }

    /**
     * Setter method for productCategory.
     *
     * @param aProductCategory the new value for productCategory
     */
    public void setProductCategory(ProductCategory aProductCategory) {
        productCategory = aProductCategory;
    }

    /** Temporary value holder for group key fragment productCategoryProductCategoryId */
    private transient int tempProductCategoryProductCategoryId;

    /**
     * Gets the key fragment productCategoryId for member productCategory.
     * If this.productCategory is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setProductCategoryProductCategoryId.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see ProductCategory
     */
    public int getProductCategoryProductCategoryId() {
        return (getProductCategory() == null ? tempProductCategoryProductCategoryId : getProductCategory().getProductCategoryId());
    }

    /**
     * Sets the key fragment productCategoryId from member productCategory.
     * If this.productCategory is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getProductCategoryProductCategoryId.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aProductCategoryId New value for the key fragment
     * @see ProductCategory
     */
    public void setProductCategoryProductCategoryId(int aProductCategoryId) {
        if (getProductCategory() == null) {
            tempProductCategoryProductCategoryId = aProductCategoryId;
        } else {
            getProductCategory().setProductCategoryId(aProductCategoryId);
        }
    }

    /** Temporary value holder for group key fragment productLotLotId */
    private transient int tempProductLotLotId;

    /**
     * Gets the key fragment lotId for member productLot.
     * If this.productLot is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setProductLotLotId.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see ProductLot
     */
    public int getProductLotLotId() {
        return (getProductLot() == null ? tempProductLotLotId : getProductLot().getLotId());
    }

    /**
     * Sets the key fragment lotId from member productLot.
     * If this.productLot is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getProductLotLotId.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aLotId New value for the key fragment
     * @see ProductLot
     */
    public void setProductLotLotId(int aLotId) {
        if (getProductLot() == null) {
            tempProductLotLotId = aLotId;
        } else {
            getProductLot().setLotId(aLotId);
        }
    }

    /**
     * Compares the key for this instance with another ProductLotDetails.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class ProductLotDetails and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof ProductLotDetails)) {
            return false;
        }
        ProductLotDetails that = (ProductLotDetails) other;
        if (this.getProductCategoryProductCategoryId() != that.getProductCategoryProductCategoryId()) {
            return false;
        }
        if (this.getProductLotLotId() != that.getProductLotLotId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another ProductLotDetails.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ProductLotDetails)) return false;
        return this.equalKeys(other) && ((ProductLotDetails)other).equalKeys(this);
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
        i = getProductCategoryProductCategoryId();
        result = 37*result + i;
        i = getProductLotLotId();
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
        StringBuffer sb = new StringBuffer("[ProductLotDetails |");
        sb.append(" productCategoryProductCategoryId=").append(getProductCategoryProductCategoryId());
        sb.append(" productLotLotId=").append(getProductLotLotId());
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
        ret.put("productCategoryProductCategoryId", Integer.valueOf(getProductCategoryProductCategoryId()));
        ret.put("productLotLotId", Integer.valueOf(getProductLotLotId()));
        return ret;
    }

}
