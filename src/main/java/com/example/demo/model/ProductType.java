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
import jakarta.persistence.OneToMany;

@Entity
public class ProductType implements Serializable {

    /** Primary key. */
    protected static final String PK = "productTypeId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ProductTypeID", unique=true, nullable=false, precision=3)
    private short productTypeId;
    @Column(name="TypeName", nullable=false, length=50)
    private String typeName;
    @OneToMany(mappedBy="productType")
    private Set<ProductCatalog> productCatalog;
    @OneToMany(mappedBy="productType")
    private Set<Size> size;

    /** Default constructor. */
    public ProductType() {
        super();
    }

    /**
     * Access method for productTypeId.
     *
     * @return the current value of productTypeId
     */
    public short getProductTypeId() {
        return productTypeId;
    }

    /**
     * Setter method for productTypeId.
     *
     * @param aProductTypeId the new value for productTypeId
     */
    public void setProductTypeId(short aProductTypeId) {
        productTypeId = aProductTypeId;
    }

    /**
     * Access method for typeName.
     *
     * @return the current value of typeName
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Setter method for typeName.
     *
     * @param aTypeName the new value for typeName
     */
    public void setTypeName(String aTypeName) {
        typeName = aTypeName;
    }

    /**
     * Access method for productCatalog.
     *
     * @return the current value of productCatalog
     */
    public Set<ProductCatalog> getProductCatalog() {
        return productCatalog;
    }

    /**
     * Setter method for productCatalog.
     *
     * @param aProductCatalog the new value for productCatalog
     */
    public void setProductCatalog(Set<ProductCatalog> aProductCatalog) {
        productCatalog = aProductCatalog;
    }

    /**
     * Access method for size.
     *
     * @return the current value of size
     */
    public Set<Size> getSize() {
        return size;
    }

    /**
     * Setter method for size.
     *
     * @param aSize the new value for size
     */
    public void setSize(Set<Size> aSize) {
        size = aSize;
    }

    /**
     * Compares the key for this instance with another ProductType.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class ProductType and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof ProductType)) {
            return false;
        }
        ProductType that = (ProductType) other;
        if (this.getProductTypeId() != that.getProductTypeId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another ProductType.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ProductType)) return false;
        return this.equalKeys(other) && ((ProductType)other).equalKeys(this);
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
        i = getProductTypeId();
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
        StringBuffer sb = new StringBuffer("[ProductType |");
        sb.append(" productTypeId=").append(getProductTypeId());
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
        ret.put("productTypeId", Short.valueOf(getProductTypeId()));
        return ret;
    }

}
