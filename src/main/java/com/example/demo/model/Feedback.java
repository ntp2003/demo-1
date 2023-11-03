// Generated with g9.

package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(Feedback.FeedbackId.class)
public class Feedback implements Serializable {

    /**
     * IdClass for primary key when using JPA annotations
     */
    public class FeedbackId implements Serializable {
        CustomerAccount customerAccount;
        PurchaseInvoice purchaseInvoice;
        ProductCategory productCategory;
    }

    /** Primary key. */
    protected static final String PK = "FeedbackPkFeedback";

    @Column(name="Review")
    private String review;
    @Column(name="Time", nullable=false)
    private LocalDateTime time;
    @Column(name="Rating", precision=3)
    private short rating;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="AccountID", nullable=false)
    private CustomerAccount customerAccount;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="InvoiceID", nullable=false)
    private PurchaseInvoice purchaseInvoice;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="ProductCategoryID", nullable=false)
    private ProductCategory productCategory;

    /** Default constructor. */
    public Feedback() {
        super();
    }

    /**
     * Access method for review.
     *
     * @return the current value of review
     */
    public String getReview() {
        return review;
    }

    /**
     * Setter method for review.
     *
     * @param aReview the new value for review
     */
    public void setReview(String aReview) {
        review = aReview;
    }

    /**
     * Access method for time.
     *
     * @return the current value of time
     */
    public LocalDateTime getTime() {
        return time;
    }

    /**
     * Setter method for time.
     *
     * @param aTime the new value for time
     */
    public void setTime(LocalDateTime aTime) {
        time = aTime;
    }

    /**
     * Access method for rating.
     *
     * @return the current value of rating
     */
    public short getRating() {
        return rating;
    }

    /**
     * Setter method for rating.
     *
     * @param aRating the new value for rating
     */
    public void setRating(short aRating) {
        rating = aRating;
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

    /**
     * Compares the key for this instance with another Feedback.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Feedback and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Feedback)) {
            return false;
        }
        Feedback that = (Feedback) other;
        if (this.getCustomerAccountAccountId() != that.getCustomerAccountAccountId()) {
            return false;
        }
        if (this.getPurchaseInvoiceInvoiceId() != that.getPurchaseInvoiceInvoiceId()) {
            return false;
        }
        if (this.getProductCategoryProductCategoryId() != that.getProductCategoryProductCategoryId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Feedback.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Feedback)) return false;
        return this.equalKeys(other) && ((Feedback)other).equalKeys(this);
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
        i = getPurchaseInvoiceInvoiceId();
        result = 37*result + i;
        i = getProductCategoryProductCategoryId();
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
        StringBuffer sb = new StringBuffer("[Feedback |");
        sb.append(" customerAccountAccountId=").append(getCustomerAccountAccountId());
        sb.append(" purchaseInvoiceInvoiceId=").append(getPurchaseInvoiceInvoiceId());
        sb.append(" productCategoryProductCategoryId=").append(getProductCategoryProductCategoryId());
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
        ret.put("purchaseInvoiceInvoiceId", Integer.valueOf(getPurchaseInvoiceInvoiceId()));
        ret.put("productCategoryProductCategoryId", Integer.valueOf(getProductCategoryProductCategoryId()));
        return ret;
    }

}
