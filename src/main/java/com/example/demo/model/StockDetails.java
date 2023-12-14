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
public class StockDetails implements Serializable {

    /** Primary key. */
    protected static final String PK = "stockInventoryId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="StockInventoryID", unique=true, nullable=false, precision=10)
    private int stockInventoryId;
    @Column(name="Stock", nullable=false, precision=10)
    private int stock;
    @OneToMany(mappedBy="stockDetails")
    private Set<Feedback> feedback;
    @OneToMany(mappedBy="stockDetails")
    private Set<InvoiceDetail> invoiceDetail;
    @OneToMany(mappedBy="productLotDetailsId.stockDetails")
    private Set<ProductLotDetails> productLotDetails;
    @OneToMany(mappedBy="stockDetails")
    private Set<ShoppingCart> shoppingCart;
    @ManyToOne(optional=false)
    @JoinColumn(name="ProductCategoryID", nullable=false)
    private ProductCategory productCategory;
    @ManyToOne(optional=false)
    @JoinColumn(name="SizeID", nullable=false)
    private Size size;

    /** Default constructor. */
    public StockDetails() {
        super();
    }

    /**
     * Access method for stockInventoryId.
     *
     * @return the current value of stockInventoryId
     */
    public int getStockInventoryId() {
        return stockInventoryId;
    }

    /**
     * Setter method for stockInventoryId.
     *
     * @param aStockInventoryId the new value for stockInventoryId
     */
    public void setStockInventoryId(int aStockInventoryId) {
        stockInventoryId = aStockInventoryId;
    }

    /**
     * Access method for stock.
     *
     * @return the current value of stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Setter method for stock.
     *
     * @param aStock the new value for stock
     */
    public void setStock(int aStock) {
        stock = aStock;
    }

    /**
     * Access method for feedback.
     *
     * @return the current value of feedback
     */
    public Set<Feedback> getFeedback() {
        return feedback;
    }

    /**
     * Setter method for feedback.
     *
     * @param aFeedback the new value for feedback
     */
    public void setFeedback(Set<Feedback> aFeedback) {
        feedback = aFeedback;
    }

    /**
     * Access method for invoiceDetail.
     *
     * @return the current value of invoiceDetail
     */
    public Set<InvoiceDetail> getInvoiceDetail() {
        return invoiceDetail;
    }

    /**
     * Setter method for invoiceDetail.
     *
     * @param aInvoiceDetail the new value for invoiceDetail
     */
    public void setInvoiceDetail(Set<InvoiceDetail> aInvoiceDetail) {
        invoiceDetail = aInvoiceDetail;
    }

    /**
     * Access method for productLotDetails.
     *
     * @return the current value of productLotDetails
     */
    public Set<ProductLotDetails> getProductLotDetails() {
        return productLotDetails;
    }

    /**
     * Setter method for productLotDetails.
     *
     * @param aProductLotDetails the new value for productLotDetails
     */
    public void setProductLotDetails(Set<ProductLotDetails> aProductLotDetails) {
        productLotDetails = aProductLotDetails;
    }

    /**
     * Access method for shoppingCart.
     *
     * @return the current value of shoppingCart
     */
    public Set<ShoppingCart> getShoppingCart() {
        return shoppingCart;
    }

    /**
     * Setter method for shoppingCart.
     *
     * @param aShoppingCart the new value for shoppingCart
     */
    public void setShoppingCart(Set<ShoppingCart> aShoppingCart) {
        shoppingCart = aShoppingCart;
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

    /**
     * Access method for size.
     *
     * @return the current value of size
     */
    public Size getSize() {
        return size;
    }

    /**
     * Setter method for size.
     *
     * @param aSize the new value for size
     */
    public void setSize(Size aSize) {
        size = aSize;
    }

    /**
     * Compares the key for this instance with another StockDetails.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class StockDetails and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof StockDetails)) {
            return false;
        }
        StockDetails that = (StockDetails) other;
        if (this.getStockInventoryId() != that.getStockInventoryId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another StockDetails.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof StockDetails)) return false;
        return this.equalKeys(other) && ((StockDetails)other).equalKeys(this);
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
        i = getStockInventoryId();
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
        StringBuffer sb = new StringBuffer("[StockDetails |");
        sb.append(" stockInventoryId=").append(getStockInventoryId());
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
        ret.put("stockInventoryId", Integer.valueOf(getStockInventoryId()));
        return ret;
    }

}
