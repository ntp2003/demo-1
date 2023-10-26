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
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(indexes={@Index(name="CustomerAccount_PhoneNumber_IX", columnList="PhoneNumber", unique=true)})
public class CustomerAccount implements Serializable {

    /** Primary key. */
    protected static final String PK = "accountId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="AccountID", unique=true, nullable=false, precision=10)
    private int accountId;
    @Column(name="Password", nullable=false, length=30)
    private String password;
    @Column(name="CustomerName", nullable=false, length=50)
    private String customerName;
    @Column(name="BirthDate")
    private LocalDate birthDate;
    @Column(name="Address", length=100)
    private String address;
    @Column(name="PhoneNumber", unique=true, length=10)
    private String phoneNumber;
    @Column(name="Email", nullable=false, length=100)
    private String email;
    @ManyToOne
    @JoinColumn(name="WalletID")
    private ElectronicWallet electronicWallet;
    @OneToMany(mappedBy="customerAccount")
    private Set<Feedback> feedback;
    @OneToMany(mappedBy="customerAccount")
    private Set<LoginHistory> loginHistory;
    @OneToMany(mappedBy="customerAccount")
    private Set<PurchaseHistory> purchaseHistory;
    @OneToMany(mappedBy="customerAccount")
    private Set<ShoppingCart> shoppingCart;

    /** Default constructor. */
    public CustomerAccount() {
        super();
    }

    /**
     * Access method for accountId.
     *
     * @return the current value of accountId
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * Setter method for accountId.
     *
     * @param aAccountId the new value for accountId
     */
    public void setAccountId(int aAccountId) {
        accountId = aAccountId;
    }

    /**
     * Access method for password.
     *
     * @return the current value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for password.
     *
     * @param aPassword the new value for password
     */
    public void setPassword(String aPassword) {
        password = aPassword;
    }

    /**
     * Access method for customerName.
     *
     * @return the current value of customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Setter method for customerName.
     *
     * @param aCustomerName the new value for customerName
     */
    public void setCustomerName(String aCustomerName) {
        customerName = aCustomerName;
    }

    /**
     * Access method for birthDate.
     *
     * @return the current value of birthDate
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Setter method for birthDate.
     *
     * @param aBirthDate the new value for birthDate
     */
    public void setBirthDate(LocalDate aBirthDate) {
        birthDate = aBirthDate;
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
     * Access method for email.
     *
     * @return the current value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for email.
     *
     * @param aEmail the new value for email
     */
    public void setEmail(String aEmail) {
        email = aEmail;
    }

    /**
     * Access method for electronicWallet.
     *
     * @return the current value of electronicWallet
     */
    public ElectronicWallet getElectronicWallet() {
        return electronicWallet;
    }

    /**
     * Setter method for electronicWallet.
     *
     * @param aElectronicWallet the new value for electronicWallet
     */
    public void setElectronicWallet(ElectronicWallet aElectronicWallet) {
        electronicWallet = aElectronicWallet;
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
     * Access method for loginHistory.
     *
     * @return the current value of loginHistory
     */
    public Set<LoginHistory> getLoginHistory() {
        return loginHistory;
    }

    /**
     * Setter method for loginHistory.
     *
     * @param aLoginHistory the new value for loginHistory
     */
    public void setLoginHistory(Set<LoginHistory> aLoginHistory) {
        loginHistory = aLoginHistory;
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
     * Compares the key for this instance with another CustomerAccount.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class CustomerAccount and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof CustomerAccount)) {
            return false;
        }
        CustomerAccount that = (CustomerAccount) other;
        if (this.getAccountId() != that.getAccountId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another CustomerAccount.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof CustomerAccount)) return false;
        return this.equalKeys(other) && ((CustomerAccount)other).equalKeys(this);
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
        i = getAccountId();
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
        StringBuffer sb = new StringBuffer("[CustomerAccount |");
        sb.append(" accountId=").append(getAccountId());
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
        ret.put("accountId", Integer.valueOf(getAccountId()));
        return ret;
    }

}
