// Generated with g9.

package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LoginHistory implements Serializable {

    /** Primary key. */
    protected static final String PK = "loginId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="LoginID", unique=true, nullable=false, precision=10)
    private int loginId;
    @Column(name="LoginTime", nullable=false)
    private LocalDateTime loginTime;
    @Column(name="Status", nullable=false, length=255)
    private String status;
    @ManyToOne(optional=false)
    @JoinColumn(name="AccountID", nullable=false)
    private CustomerAccount customerAccount;

    /** Default constructor. */
    public LoginHistory() {
        super();
    }

    /**
     * Access method for loginId.
     *
     * @return the current value of loginId
     */
    public int getLoginId() {
        return loginId;
    }

    /**
     * Setter method for loginId.
     *
     * @param aLoginId the new value for loginId
     */
    public void setLoginId(int aLoginId) {
        loginId = aLoginId;
    }

    /**
     * Access method for loginTime.
     *
     * @return the current value of loginTime
     */
    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    /**
     * Setter method for loginTime.
     *
     * @param aLoginTime the new value for loginTime
     */
    public void setLoginTime(LocalDateTime aLoginTime) {
        loginTime = aLoginTime;
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
     * Compares the key for this instance with another LoginHistory.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class LoginHistory and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof LoginHistory)) {
            return false;
        }
        LoginHistory that = (LoginHistory) other;
        if (this.getLoginId() != that.getLoginId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another LoginHistory.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof LoginHistory)) return false;
        return this.equalKeys(other) && ((LoginHistory)other).equalKeys(this);
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
        i = getLoginId();
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
        StringBuffer sb = new StringBuffer("[LoginHistory |");
        sb.append(" loginId=").append(getLoginId());
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
        ret.put("loginId", Integer.valueOf(getLoginId()));
        return ret;
    }

}
