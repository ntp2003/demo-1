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
@IdClass(InvoiceDetail.InvoiceDetailId.class)
public class InvoiceDetail implements Serializable {

    /**
     * IdClass for primary key when using JPA annotations
     */
    public class InvoiceDetailId implements Serializable {
        PurchaseInvoice purchaseInvoice;
        StockDetails stockDetails;
    }

    /** Primary key. */
    protected static final String PK = "InvoiceDetailPkInvoiceDetail";

    @Column(name="Quantity", nullable=false, precision=10)
    private int quantity;
    @Column(name="OriginalPrice", nullable=false, precision=19, scale=4)
    private BigDecimal originalPrice;
    @Column(name="Discount", nullable=false, precision=19, scale=4)
    private BigDecimal discount;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="InvoiceID", nullable=false)
    private PurchaseInvoice purchaseInvoice;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="StockInventoryID", nullable=false)
    private StockDetails stockDetails;

    /** Default constructor. */
    public InvoiceDetail() {
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
     * Access method for originalPrice.
     *
     * @return the current value of originalPrice
     */
    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    /**
     * Setter method for originalPrice.
     *
     * @param aOriginalPrice the new value for originalPrice
     */
    public void setOriginalPrice(BigDecimal aOriginalPrice) {
        originalPrice = aOriginalPrice;
    }

    /**
     * Access method for discount.
     *
     * @return the current value of discount
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * Setter method for discount.
     *
     * @param aDiscount the new value for discount
     */
    public void setDiscount(BigDecimal aDiscount) {
        discount = aDiscount;
    }

    /**
     * Access method for purchaseInvoice.
     *
     * @return the current value of purchaseInvoice
     */
    public PurchaseInvoice getPurchaseInvoice() {
        return purchaseInvoice;
    }

    /**
     * Setter method for purchaseInvoice.
     *
     * @param aPurchaseInvoice the new value for purchaseInvoice
     */
    public void setPurchaseInvoice(PurchaseInvoice aPurchaseInvoice) {
        purchaseInvoice = aPurchaseInvoice;
    }

    /**
     * Access method for stockDetails.
     *
     * @return the current value of stockDetails
     */
    public StockDetails getStockDetails() {
        return stockDetails;
    }

    /**
     * Setter method for stockDetails.
     *
     * @param aStockDetails the new value for stockDetails
     */
    public void setStockDetails(StockDetails aStockDetails) {
        stockDetails = aStockDetails;
    }

    /** Temporary value holder for group key fragment purchaseInvoiceInvoiceId */
    private transient int tempPurchaseInvoiceInvoiceId;

    /**
     * Gets the key fragment invoiceId for member purchaseInvoice.
     * If this.purchaseInvoice is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setPurchaseInvoiceInvoiceId.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see PurchaseInvoice
     */
    public int getPurchaseInvoiceInvoiceId() {
        return (getPurchaseInvoice() == null ? tempPurchaseInvoiceInvoiceId : getPurchaseInvoice().getInvoiceId());
    }

    /**
     * Sets the key fragment invoiceId from member purchaseInvoice.
     * If this.purchaseInvoice is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getPurchaseInvoiceInvoiceId.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aInvoiceId New value for the key fragment
     * @see PurchaseInvoice
     */
    public void setPurchaseInvoiceInvoiceId(int aInvoiceId) {
        if (getPurchaseInvoice() == null) {
            tempPurchaseInvoiceInvoiceId = aInvoiceId;
        } else {
            getPurchaseInvoice().setInvoiceId(aInvoiceId);
        }
    }

    /** Temporary value holder for group key fragment stockDetailsStockInventoryId */
    private transient int tempStockDetailsStockInventoryId;

    /**
     * Gets the key fragment stockInventoryId for member stockDetails.
     * If this.stockDetails is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setStockDetailsStockInventoryId.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see StockDetails
     */
    public int getStockDetailsStockInventoryId() {
        return (getStockDetails() == null ? tempStockDetailsStockInventoryId : getStockDetails().getStockInventoryId());
    }

    /**
     * Sets the key fragment stockInventoryId from member stockDetails.
     * If this.stockDetails is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getStockDetailsStockInventoryId.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aStockInventoryId New value for the key fragment
     * @see StockDetails
     */
    public void setStockDetailsStockInventoryId(int aStockInventoryId) {
        if (getStockDetails() == null) {
            tempStockDetailsStockInventoryId = aStockInventoryId;
        } else {
            getStockDetails().setStockInventoryId(aStockInventoryId);
        }
    }

    /**
     * Compares the key for this instance with another InvoiceDetail.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class InvoiceDetail and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof InvoiceDetail)) {
            return false;
        }
        InvoiceDetail that = (InvoiceDetail) other;
        if (this.getPurchaseInvoiceInvoiceId() != that.getPurchaseInvoiceInvoiceId()) {
            return false;
        }
        if (this.getStockDetailsStockInventoryId() != that.getStockDetailsStockInventoryId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another InvoiceDetail.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof InvoiceDetail)) return false;
        return this.equalKeys(other) && ((InvoiceDetail)other).equalKeys(this);
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
        i = getPurchaseInvoiceInvoiceId();
        result = 37*result + i;
        i = getStockDetailsStockInventoryId();
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
        StringBuffer sb = new StringBuffer("[InvoiceDetail |");
        sb.append(" purchaseInvoiceInvoiceId=").append(getPurchaseInvoiceInvoiceId());
        sb.append(" stockDetailsStockInventoryId=").append(getStockDetailsStockInventoryId());
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
        ret.put("purchaseInvoiceInvoiceId", Integer.valueOf(getPurchaseInvoiceInvoiceId()));
        ret.put("stockDetailsStockInventoryId", Integer.valueOf(getStockDetailsStockInventoryId()));
        return ret;
    }

}
