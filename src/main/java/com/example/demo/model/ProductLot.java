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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ProductLot implements Serializable {

    /** Primary key. */
    protected static final String PK = "lotId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="LotID", unique=true, nullable=false, precision=10)
    private int lotId;
    @Column(name="ImportDate", nullable=false)
    private LocalDate importDate;
    @ManyToOne(optional=false)
    @JoinColumn(name="Confirmer", nullable=false)
    private Admin admin;
    @OneToMany(mappedBy="productLotDetailsId.productLot")
    private Set<ProductLotDetails> productLotDetails;

    /** Default constructor. */
    public ProductLot() {
        super();
    }

    /**
     * Access method for lotId.
     *
     * @return the current value of lotId
     */
    public int getLotId() {
        return lotId;
    }

    /**
     * Setter method for lotId.
     *
     * @param aLotId the new value for lotId
     */
    public void setLotId(int aLotId) {
        lotId = aLotId;
    }

    /**
     * Access method for importDate.
     *
     * @return the current value of importDate
     */
    public LocalDate getImportDate() {
        return importDate;
    }

    /**
     * Setter method for importDate.
     *
     * @param aImportDate the new value for importDate
     */
    public void setImportDate(LocalDate aImportDate) {
        importDate = aImportDate;
    }

    /**
     * Access method for admin.
     *
     * @return the current value of admin
     */
    public Admin getAdmin() {
        return admin;
    }

    /**
     * Setter method for admin.
     *
     * @param aAdmin the new value for admin
     */
    public void setAdmin(Admin aAdmin) {
        admin = aAdmin;
    }

    /**
     * Access method for productLotDetails.
     *
     * @return the current value of productLotDetails
     */
    public Set<ProductLotDetails> getProductLotDetails() {
        return productLotDetails;
    }

    /**
     * Setter method for productLotDetails.
     *
     * @param aProductLotDetails the new value for productLotDetails
     */
    public void setProductLotDetails(Set<ProductLotDetails> aProductLotDetails) {
        productLotDetails = aProductLotDetails;
    }

    /**
     * Compares the key for this instance with another ProductLot.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class ProductLot and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof ProductLot)) {
            return false;
        }
        ProductLot that = (ProductLot) other;
        if (this.getLotId() != that.getLotId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another ProductLot.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ProductLot)) return false;
        return this.equalKeys(other) && ((ProductLot)other).equalKeys(this);
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
        i = getLotId();
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
        StringBuffer sb = new StringBuffer("[ProductLot |");
        sb.append(" lotId=").append(getLotId());
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
        ret.put("lotId", Integer.valueOf(getLotId()));
        return ret;
    }

}
