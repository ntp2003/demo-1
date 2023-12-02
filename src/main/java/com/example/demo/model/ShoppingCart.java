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
@IdClass(ShoppingCart.ShoppingCartId.class)
public class ShoppingCart implements Serializable {

    /**
     * IdClass for primary key when using JPA annotations
     */
    public class ShoppingCartId implements Serializable {
        CustomerAccount customerAccount;
        StockDetails stockDetails;
    }

    /** Primary key. */
    protected static final String PK = "ShoppingCartPkCart";

    @Column(name="Quantity", nullable=false, precision=10)
    private int quantity;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="AccountID", nullable=false)
    private CustomerAccount customerAccount;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="StockInventoryID", nullable=false)
    private StockDetails stockDetails;

    /** Default constructor. */
    public ShoppingCart() {
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
     * Access method for customerAccount.
     *
     * @return the current value of customerAccount
     */
    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    /**
     * Setter method for customerAccount.
     *
     * @param aCustomerAccount the new value for customerAccount
     */
    public void setCustomerAccount(CustomerAccount aCustomerAccount) {
        customerAccount = aCustomerAccount;
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

    /** Temporary value holder for group key fragment customerAccountAccountId */
    private transient int tempCustomerAccountAccountId;

    /**
     * Gets the key fragment accountId for member customerAccount.
     * If this.customerAccount is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setCustomerAccountAccountId.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see CustomerAccount
     */
    public int getCustomerAccountAccountId() {
        return (getCustomerAccount() == null ? tempCustomerAccountAccountId : getCustomerAccount().getAccountId());
    }

    /**
     * Sets the key fragment accountId from member customerAccount.
     * If this.customerAccount is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getCustomerAccountAccountId.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aAccountId New value for the key fragment
     * @see CustomerAccount
     */
    public void setCustomerAccountAccountId(int aAccountId) {
        if (getCustomerAccount() == null) {
            tempCustomerAccountAccountId = aAccountId;
        } else {
            getCustomerAccount().setAccountId(aAccountId);
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
     * Compares the key for this instance with another ShoppingCart.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class ShoppingCart and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof ShoppingCart)) {
            return false;
        }
        ShoppingCart that = (ShoppingCart) other;
        if (this.getCustomerAccountAccountId() != that.getCustomerAccountAccountId()) {
            return false;
        }
        if (this.getStockDetailsStockInventoryId() != that.getStockDetailsStockInventoryId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another ShoppingCart.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ShoppingCart)) return false;
        return this.equalKeys(other) && ((ShoppingCart)other).equalKeys(this);
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
        i = getCustomerAccountAccountId();
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
        StringBuffer sb = new StringBuffer("[ShoppingCart |");
        sb.append(" customerAccountAccountId=").append(getCustomerAccountAccountId());
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
        ret.put("customerAccountAccountId", Integer.valueOf(getCustomerAccountAccountId()));
        ret.put("stockDetailsStockInventoryId", Integer.valueOf(getStockDetailsStockInventoryId()));
        return ret;
    }

}
