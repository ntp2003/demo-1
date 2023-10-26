// Generated with g9.

package com.example.demo.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Payment implements Serializable {

    /** Primary key. */
    protected static final String PK = "paymentMethod";

    @Id
    @Column(name="PaymentMethod", unique=true, nullable=false, precision=3)
    private short paymentMethod;
    @Column(name="Description", nullable=false, length=100)
    private String description;
    @OneToMany(mappedBy="payment")
    private Set<PurchaseInvoice> purchaseInvoice;

    /** Default constructor. */
    public Payment() {
        super();
    }

    /**
     * Access method for paymentMethod.
     *
     * @return the current value of paymentMethod
     */
    public short getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Setter method for paymentMethod.
     *
     * @param aPaymentMethod the new value for paymentMethod
     */
    public void setPaymentMethod(short aPaymentMethod) {
        paymentMethod = aPaymentMethod;
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
     * Access method for purchaseInvoice.
     *
     * @return the current value of purchaseInvoice
     */
    public Set<PurchaseInvoice> getPurchaseInvoice() {
        return purchaseInvoice;
    }

    /**
     * Setter method for purchaseInvoice.
     *
     * @param aPurchaseInvoice the new value for purchaseInvoice
     */
    public void setPurchaseInvoice(Set<PurchaseInvoice> aPurchaseInvoice) {
        purchaseInvoice = aPurchaseInvoice;
    }

    /**
     * Compares the key for this instance with another Payment.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Payment and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Payment)) {
            return false;
        }
        Payment that = (Payment) other;
        if (this.getPaymentMethod() != that.getPaymentMethod()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Payment.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Payment)) return false;
        return this.equalKeys(other) && ((Payment)other).equalKeys(this);
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
        i = getPaymentMethod();
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
        StringBuffer sb = new StringBuffer("[Payment |");
        sb.append(" paymentMethod=").append(getPaymentMethod());
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
        ret.put("paymentMethod", Short.valueOf(getPaymentMethod()));
        return ret;
    }

}
