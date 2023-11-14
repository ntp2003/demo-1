// Generated with g9.

package com.example.demo.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(indexes={@Index(name="Admin_PhoneNumber_IX", columnList="PhoneNumber", unique=true), @Index(name="Admin_Email_IX", columnList="Email", unique=true), @Index(name="Admin_CCCD_IX", columnList="CCCD", unique=true)})
public class Admin implements Serializable {

    /** Primary key. */
    protected static final String PK = "username";

    @Id
    @Column(name="Username", unique=true, nullable=false, length=100)
    private String username;
    @Column(name="Password", nullable=false, length=500)
    private String password;
    @Column(name="FullName", nullable=false, length=100)
    private String fullName;
    @Column(name="PhoneNumber", unique=true, nullable=false, length=10)
    private String phoneNumber;
    @Column(name="Email", unique=true, nullable=false, length=255)
    private String email;
    @Column(name="CCCD", unique=true, nullable=false, length=12)
    private String cccd;
    @OneToMany(mappedBy="admin")
    private Set<ProductLot> productLot;

    /** Default constructor. */
    public Admin() {
        super();
    }

    /**
     * Access method for username.
     *
     * @return the current value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method for username.
     *
     * @param aUsername the new value for username
     */
    public void setUsername(String aUsername) {
        username = aUsername;
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
     * Access method for fullName.
     *
     * @return the current value of fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Setter method for fullName.
     *
     * @param aFullName the new value for fullName
     */
    public void setFullName(String aFullName) {
        fullName = aFullName;
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
     * Access method for cccd.
     *
     * @return the current value of cccd
     */
    public String getCccd() {
        return cccd;
    }

    /**
     * Setter method for cccd.
     *
     * @param aCccd the new value for cccd
     */
    public void setCccd(String aCccd) {
        cccd = aCccd;
    }

    /**
     * Access method for productLot.
     *
     * @return the current value of productLot
     */
    public Set<ProductLot> getProductLot() {
        return productLot;
    }

    /**
     * Setter method for productLot.
     *
     * @param aProductLot the new value for productLot
     */
    public void setProductLot(Set<ProductLot> aProductLot) {
        productLot = aProductLot;
    }

    /**
     * Compares the key for this instance with another Admin.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Admin and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Admin)) {
            return false;
        }
        Admin that = (Admin) other;
        Object myUsername = this.getUsername();
        Object yourUsername = that.getUsername();
        if (myUsername==null ? yourUsername!=null : !myUsername.equals(yourUsername)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Admin.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Admin)) return false;
        return this.equalKeys(other) && ((Admin)other).equalKeys(this);
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
        if (getUsername() == null) {
            i = 0;
        } else {
            i = getUsername().hashCode();
        }
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
        StringBuffer sb = new StringBuffer("[Admin |");
        sb.append(" username=").append(getUsername());
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
        ret.put("username", getUsername());
        return ret;
    }

}
