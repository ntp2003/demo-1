// Generated with g9.

package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(indexes={@Index(name="PurchaseInvoice_PhoneNumber_IX", columnList="PhoneNumber", unique=true)})
public class PurchaseInvoice implements Serializable {

    /** Primary key. */
    protected static final String PK = "invoiceId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="InvoiceID", unique=true, nullable=false, precision=10)
    private int invoiceId;
    @Column(name="CreatedTime", nullable=false)
    private LocalDateTime createdTime;
    @Column(name="Address", nullable=false, length=100)
    private String address;
    @Column(name="PhoneNumber", nullable=false, length=10)
    private String phoneNumber;
    @Column(name="OriginalPrice", nullable=false, precision=19, scale=4)
    private BigDecimal originalPrice;
    @Column(name="Discount", nullable=false, precision=19, scale=4)
    private BigDecimal discount;
    @Column(name="ShippingFee", nullable=false, precision=19, scale=4)
    private BigDecimal shippingFee;
    @Column(name="Total", nullable=false, precision=19, scale=4)
    private BigDecimal total;
    @Column(name="CompletedTime")
    private LocalDateTime completedTime;
    @OneToMany(mappedBy="invoiceDetailId.purchaseInvoice")
    private Set<InvoiceDetail> invoiceDetail;
    @OneToMany(mappedBy="purchaseInvoice")
    private Set<PurchaseHistory> purchaseHistory;
    @ManyToOne(optional=false)
    @JoinColumn(name="PaymentMethod", nullable=false)
    private Payment payment;

    /** Default constructor. */
    public PurchaseInvoice() {
        super();
    }

    /**
     * Access method for invoiceId.
     *
     * @return the current value of invoiceId
     */
    public int getInvoiceId() {
        return invoiceId;
    }

    /**
     * Setter method for invoiceId.
     *
     * @param aInvoiceId the new value for invoiceId
     */
    public void setInvoiceId(int aInvoiceId) {
        invoiceId = aInvoiceId;
    }

    /**
     * Access method for createdTime.
     *
     * @return the current value of createdTime
     */
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    /**
     * Setter method for createdTime.
     *
     * @param aCreatedTime the new value for createdTime
     */
    public void setCreatedTime(LocalDateTime aCreatedTime) {
        createdTime = aCreatedTime;
    }

    /**
     * Access method for address.
     *
     * @return the current value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter method for address.
     *
     * @param aAddress the new value for address
     */
    public void setAddress(String aAddress) {
        address = aAddress;
    }

    /**
     * Access method for phoneNumber.
     *
     * @return the current value of phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter method for phoneNumber.
     *
     * @param aPhoneNumber the new value for phoneNumber
     */
    public void setPhoneNumber(String aPhoneNumber) {
        phoneNumber = aPhoneNumber;
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
     * Access method for shippingFee.
     *
     * @return the current value of shippingFee
     */
    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    /**
     * Setter method for shippingFee.
     *
     * @param aShippingFee the new value for shippingFee
     */
    public void setShippingFee(BigDecimal aShippingFee) {
        shippingFee = aShippingFee;
    }

    /**
     * Access method for total.
     *
     * @return the current value of total
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * Setter method for total.
     *
     * @param aTotal the new value for total
     */
    public void setTotal(BigDecimal aTotal) {
        total = aTotal;
    }

    /**
     * Access method for completedTime.
     *
     * @return the current value of completedTime
     */
    public LocalDateTime getCompletedTime() {
        return completedTime;
    }

    /**
     * Setter method for completedTime.
     *
     * @param aCompletedTime the new value for completedTime
     */
    public void setCompletedTime(LocalDateTime aCompletedTime) {
        completedTime = aCompletedTime;
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
     * Access method for purchaseHistory.
     *
     * @return the current value of purchaseHistory
     */
    public Set<PurchaseHistory> getPurchaseHistory() {
        return purchaseHistory;
    }

    /**
     * Setter method for purchaseHistory.
     *
     * @param aPurchaseHistory the new value for purchaseHistory
     */
    public void setPurchaseHistory(Set<PurchaseHistory> aPurchaseHistory) {
        purchaseHistory = aPurchaseHistory;
    }

    /**
     * Access method for payment.
     *
     * @return the current value of payment
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * Setter method for payment.
     *
     * @param aPayment the new value for payment
     */
    public void setPayment(Payment aPayment) {
        payment = aPayment;
    }

    /**
     * Compares the key for this instance with another PurchaseInvoice.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class PurchaseInvoice and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof PurchaseInvoice)) {
            return false;
        }
        PurchaseInvoice that = (PurchaseInvoice) other;
        if (this.getInvoiceId() != that.getInvoiceId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another PurchaseInvoice.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PurchaseInvoice)) return false;
        return this.equalKeys(other) && ((PurchaseInvoice)other).equalKeys(this);
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
        i = getInvoiceId();
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
        StringBuffer sb = new StringBuffer("[PurchaseInvoice |");
        sb.append(" invoiceId=").append(getInvoiceId());
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
        ret.put("invoiceId", Integer.valueOf(getInvoiceId()));
        return ret;
    }

}
