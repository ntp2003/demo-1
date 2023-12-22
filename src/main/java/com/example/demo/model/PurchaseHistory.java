// Generated with g9.

package com.example.demo.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class PurchaseHistory implements Serializable {

    /** Primary key. */
    protected static final String PK = "purchaseId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PurchaseID", unique=true, nullable=false, precision=10)
    private int purchaseId;
    @Column(name="Status", nullable=false, length=30)
    private String status;
    @OneToMany(mappedBy="feedbackId.purchaseHistory")
    private Set<Feedback> feedback;
    @ManyToOne(optional=false)
    @JoinColumn(name="AccountID", nullable=false)
    private CustomerAccount customerAccount;
    @ManyToOne(optional=false, fetch = FetchType.EAGER)
    @JoinColumn(name="InvoiceID", nullable=false)
    private PurchaseInvoice purchaseInvoice;

    /** Default constructor. */
    public PurchaseHistory() {
        super();
    }

    /**
     * Access method for purchaseId.
     *
     * @return the current value of purchaseId
     */
    public int getPurchaseId() {
        return purchaseId;
    }

    /**
     * Setter method for purchaseId.
     *
     * @param aPurchaseId the new value for purchaseId
     */
    public void setPurchaseId(int aPurchaseId) {
        purchaseId = aPurchaseId;
    }

    /**
     * Access method for status.
     *
     * @return the current value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter method for status.
     *
     * @param aStatus the new value for status
     */
    public void setStatus(String aStatus) {
        status = aStatus;
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
     * Compares the key for this instance with another PurchaseHistory.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class PurchaseHistory and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof PurchaseHistory)) {
            return false;
        }
        PurchaseHistory that = (PurchaseHistory) other;
        if (this.getPurchaseId() != that.getPurchaseId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another PurchaseHistory.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PurchaseHistory)) return false;
        return this.equalKeys(other) && ((PurchaseHistory)other).equalKeys(this);
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
        i = getPurchaseId();
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
        StringBuffer sb = new StringBuffer("[PurchaseHistory |");
        sb.append(" purchaseId=").append(getPurchaseId());
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
        ret.put("purchaseId", Integer.valueOf(getPurchaseId()));
        return ret;
    }

}
