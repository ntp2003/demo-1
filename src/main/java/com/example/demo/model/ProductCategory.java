// Generated with g9.

package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class ProductCategory implements Serializable {

    /** Primary key. */
    protected static final String PK = "productCategoryId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ProductCategoryID", unique=true, nullable=false, precision=10)
    private int productCategoryId;
    @Column(name="Color", nullable=false, length=100)
    private String color;
    @Column(name="Price", precision=19, scale=4)
    private BigDecimal price;
    @OneToMany(mappedBy="productCategory")
    private Set<ImageProduct> imageProduct;
    @ManyToOne(optional=false)
    @JoinColumn(name="ProductID", nullable=false)
    private ProductCatalog productCatalog;
    @OneToMany(mappedBy="productCategory")
    private Set<StockDetails> stockDetails;

    /** Default constructor. */
    public ProductCategory() {
        super();
    }

    /**
     * Access method for productCategoryId.
     *
     * @return the current value of productCategoryId
     */
    public int getProductCategoryId() {
        return productCategoryId;
    }

    /**
     * Setter method for productCategoryId.
     *
     * @param aProductCategoryId the new value for productCategoryId
     */
    public void setProductCategoryId(int aProductCategoryId) {
        productCategoryId = aProductCategoryId;
    }

    /**
     * Access method for color.
     *
     * @return the current value of color
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter method for color.
     *
     * @param aColor the new value for color
     */
    public void setColor(String aColor) {
        color = aColor;
    }

    /**
     * Access method for price.
     *
     * @return the current value of price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Setter method for price.
     *
     * @param aPrice the new value for price
     */
    public void setPrice(BigDecimal aPrice) {
        price = aPrice;
    }

    /**
     * Access method for imageProduct.
     *
     * @return the current value of imageProduct
     */
    public Set<ImageProduct> getImageProduct() {
        return imageProduct;
    }

    /**
     * Setter method for imageProduct.
     *
     * @param aImageProduct the new value for imageProduct
     */
    public void setImageProduct(Set<ImageProduct> aImageProduct) {
        imageProduct = aImageProduct;
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
     * Compares the key for this instance with another ProductCategory.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class ProductCategory and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof ProductCategory)) {
            return false;
        }
        ProductCategory that = (ProductCategory) other;
        if (this.getProductCategoryId() != that.getProductCategoryId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another ProductCategory.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ProductCategory)) return false;
        return this.equalKeys(other) && ((ProductCategory)other).equalKeys(this);
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
        i = getProductCategoryId();
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
        StringBuffer sb = new StringBuffer("[ProductCategory |");
        sb.append(" productCategoryId=").append(getProductCategoryId());
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
        ret.put("productCategoryId", Integer.valueOf(getProductCategoryId()));
        return ret;
    }

}
