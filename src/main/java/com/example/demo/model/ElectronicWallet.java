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
import jakarta.persistence.OneToMany;

@Entity
public class ElectronicWallet implements Serializable {

    /** Primary key. */
    protected static final String PK = "walletId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="WalletID", unique=true, nullable=false, precision=10)
    private int walletId;
    @Column(name="VerificationCodes", nullable=false, length=20)
    private String verificationCodes;
    @Column(name="Balance", nullable=false, precision=19, scale=4)
    private BigDecimal balance;
    @OneToMany(mappedBy="electronicWallet")
    private Set<CustomerAccount> customerAccount;

    /** Default constructor. */
    public ElectronicWallet() {
        super();
    }

    /**
     * Access method for walletId.
     *
     * @return the current value of walletId
     */
    public int getWalletId() {
        return walletId;
    }

    /**
     * Setter method for walletId.
     *
     * @param aWalletId the new value for walletId
     */
    public void setWalletId(int aWalletId) {
        walletId = aWalletId;
    }

    /**
     * Access method for verificationCodes.
     *
     * @return the current value of verificationCodes
     */
    public String getVerificationCodes() {
        return verificationCodes;
    }

    /**
     * Setter method for verificationCodes.
     *
     * @param aVerificationCodes the new value for verificationCodes
     */
    public void setVerificationCodes(String aVerificationCodes) {
        verificationCodes = aVerificationCodes;
    }

    /**
     * Access method for balance.
     *
     * @return the current value of balance
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Setter method for balance.
     *
     * @param aBalance the new value for balance
     */
    public void setBalance(BigDecimal aBalance) {
        balance = aBalance;
    }

    /**
     * Access method for customerAccount.
     *
     * @return the current value of customerAccount
     */
    public Set<CustomerAccount> getCustomerAccount() {
        return customerAccount;
    }

    /**
     * Setter method for customerAccount.
     *
     * @param aCustomerAccount the new value for customerAccount
     */
    public void setCustomerAccount(Set<CustomerAccount> aCustomerAccount) {
        customerAccount = aCustomerAccount;
    }

    /**
     * Compares the key for this instance with another ElectronicWallet.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class ElectronicWallet and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof ElectronicWallet)) {
            return false;
        }
        ElectronicWallet that = (ElectronicWallet) other;
        if (this.getWalletId() != that.getWalletId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another ElectronicWallet.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ElectronicWallet)) return false;
        return this.equalKeys(other) && ((ElectronicWallet)other).equalKeys(this);
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
        i = getWalletId();
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
        StringBuffer sb = new StringBuffer("[ElectronicWallet |");
        sb.append(" walletId=").append(getWalletId());
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
        ret.put("walletId", Integer.valueOf(getWalletId()));
        return ret;
    }

}
