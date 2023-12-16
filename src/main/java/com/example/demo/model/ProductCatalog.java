// Generated with g9.

package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDate;
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
public class ProductCatalog implements Serializable {

    /** Primary key. */
    protected static final String PK = "productId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ProductID", unique=true, nullable=false, precision=5)
    private short productId;
    @Column(name="ReleaseDate", nullable=false)
    private LocalDate releaseDate;
    @Column(name="ProductName", nullable=false, length=100)
    private String productName;
    @Column(name="Origin", nullable=false, length=100)
    private String origin;
    @Column(name="Brand", nullable=false, length=100)
    private String brand;
    @Column(name="PurchaseCount", nullable=false, precision=10)
    private int purchaseCount;
    @Column(name="Description")
    private String description;
    @ManyToOne(optional=false)
    @JoinColumn(name="ProductTypeID", nullable=false)
    private ProductType productType;
    @OneToMany(mappedBy="productCatalog")
    private Set<ProductCategory> productCategory;
    @OneToMany(mappedBy="promotionDetailId.productCatalog")
    private Set<PromotionDetail> promotionDetail;

    /** Default constructor. */
    public ProductCatalog() {
        super();
    }
    public ProductCatalog(short productId) {
        super();
        this.productId = productId;
    }

    /**
     * Access method for productId.
     *
     * @return the current value of productId
     */
    public short getProductId() {
        return productId;
    }

    /**
     * Setter method for productId.
     *
     * @param aProductId the new value for productId
     */
    public void setProductId(short aProductId) {
        productId = aProductId;
    }

    /**
     * Access method for releaseDate.
     *
     * @return the current value of releaseDate
     */
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    /**
     * Setter method for releaseDate.
     *
     * @param aReleaseDate the new value for releaseDate
     */
    public void setReleaseDate(LocalDate aReleaseDate) {
        releaseDate = aReleaseDate;
    }

    /**
     * Access method for productName.
     *
     * @return the current value of productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Setter method for productName.
     *
     * @param aProductName the new value for productName
     */
    public void setProductName(String aProductName) {
        productName = aProductName;
    }

    /**
     * Access method for origin.
     *
     * @return the current value of origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Setter method for origin.
     *
     * @param aOrigin the new value for origin
     */
    public void setOrigin(String aOrigin) {
        origin = aOrigin;
    }

    /**
     * Access method for brand.
     *
     * @return the current value of brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Setter method for brand.
     *
     * @param aBrand the new value for brand
     */
    public void setBrand(String aBrand) {
        brand = aBrand;
    }

    /**
     * Access method for purchaseCount.
     *
     * @return the current value of purchaseCount
     */
    public int getPurchaseCount() {
        return purchaseCount;
    }

    /**
     * Setter method for purchaseCount.
     *
     * @param aPurchaseCount the new value for purchaseCount
     */
    public void setPurchaseCount(int aPurchaseCount) {
        purchaseCount = aPurchaseCount;
    }

    /**
     * Access method for description.
     *
     * @return the current value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for description.
     *
     * @param aDescription the new value for description
     */
    public void setDescription(String aDescription) {
        description = aDescription;
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
     * Access method for productCategory.
     *
     * @return the current value of productCategory
     */
    public Set<ProductCategory> getProductCategory() {
        return productCategory;
    }

    /**
     * Setter method for productCategory.
     *
     * @param aProductCategory the new value for productCategory
     */
    public void setProductCategory(Set<ProductCategory> aProductCategory) {
        productCategory = aProductCategory;
    }

    /**
     * Access method for promotionDetail.
     *
     * @return the current value of promotionDetail
     */
    public Set<PromotionDetail> getPromotionDetail() {
        return promotionDetail;
    }

    /**
     * Setter method for promotionDetail.
     *
     * @param aPromotionDetail the new value for promotionDetail
     */
    public void setPromotionDetail(Set<PromotionDetail> aPromotionDetail) {
        promotionDetail = aPromotionDetail;
    }

    /**
     * Compares the key for this instance with another ProductCatalog.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class ProductCatalog and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof ProductCatalog)) {
            return false;
        }
        ProductCatalog that = (ProductCatalog) other;
        if (this.getProductId() != that.getProductId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another ProductCatalog.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ProductCatalog)) return false;
        return this.equalKeys(other) && ((ProductCatalog)other).equalKeys(this);
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
        i = getProductId();
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
        StringBuffer sb = new StringBuffer("[ProductCatalog |");
        sb.append(" productId=").append(getProductId());
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
        ret.put("productId", Short.valueOf(getProductId()));
        return ret;
    }

}
