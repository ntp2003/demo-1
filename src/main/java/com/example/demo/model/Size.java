// Generated with g9.

package com.example.demo.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Size implements Serializable {

    /** Primary key. */
    protected static final String PK = "sizeId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="SizeID", unique=true, nullable=false, precision=3)
    private short sizeId;
    @Column(name="SizeName", nullable=false, length=255)
    private String sizeName;
    @ManyToOne(optional=false)
    @JoinColumn(name="ProductTypeID", nullable=false)
    private ProductType productType;
    @OneToMany(mappedBy="size")
    private Set<StockDetails> stockDetails;

    /** Default constructor. */
    public Size() {
        super();
    }

    /**
     * Access method for sizeId.
     *
     * @return the current value of sizeId
     */
    public short getSizeId() {
        return sizeId;
    }

    /**
     * Setter method for sizeId.
     *
     * @param aSizeId the new value for sizeId
     */
    public void setSizeId(short aSizeId) {
        sizeId = aSizeId;
    }

    /**
     * Access method for sizeName.
     *
     * @return the current value of sizeName
     */
    public String getSizeName() {
        return sizeName;
    }

    /**
     * Setter method for sizeName.
     *
     * @param aSizeName the new value for sizeName
     */
    public void setSizeName(String aSizeName) {
        sizeName = aSizeName;
    }

    /**
     * Access method for productType.
     *
     * @return the current value of productType
     */
    public ProductType getProductType() {
        return productType;
    }

    /**
     * Setter method for productType.
     *
     * @param aProductType the new value for productType
     */
    public void setProductType(ProductType aProductType) {
        productType = aProductType;
    }

    /**
     * Access method for stockDetails.
     *
     * @return the current value of stockDetails
     */
    public Set<StockDetails> getStockDetails() {
        return stockDetails;
    }

    /**
     * Setter method for stockDetails.
     *
     * @param aStockDetails the new value for stockDetails
     */
    public void setStockDetails(Set<StockDetails> aStockDetails) {
        stockDetails = aStockDetails;
    }

    /**
     * Compares the key for this instance with another Size.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Size and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Size)) {
            return false;
        }
        Size that = (Size) other;
        if (this.getSizeId() != that.getSizeId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Size.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Size)) return false;
        return this.equalKeys(other) && ((Size)other).equalKeys(this);
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
        i = getSizeId();
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
        StringBuffer sb = new StringBuffer("[Size |");
        sb.append(" sizeId=").append(getSizeId());
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
        ret.put("sizeId", Short.valueOf(getSizeId()));
        return ret;
    }

}
