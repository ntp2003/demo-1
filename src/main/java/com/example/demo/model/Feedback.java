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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(Feedback.FeedbackId.class)
public class Feedback implements Serializable {

    /**
     * IdClass for primary key when using JPA annotations
     */
	@Data
    public class FeedbackId implements Serializable {
        PurchaseHistory purchaseHistory;
        StockDetails stockDetails;
        
        public FeedbackId() {
        }
    }

    /** Primary key. */
    protected static final String PK = "FeedbackPkFeedback1";

    @Column(name="Review")
    private String review;
    @Column(name="Time", nullable=false)
    private LocalDateTime time;
    @Column(name="Rating", precision=3)
    private short rating;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="PurchaseID", nullable=false)
    private PurchaseHistory purchaseHistory;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="StockInventoryID", nullable=false)
    private StockDetails stockDetails;

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
     * Access method for purchaseHistory.
     *
     * @return the current value of purchaseHistory
     */
    public PurchaseHistory getPurchaseHistory() {
        return purchaseHistory;
    }

    /**
     * Setter method for purchaseHistory.
     *
     * @param aPurchaseHistory the new value for purchaseHistory
     */
    public void setPurchaseHistory(PurchaseHistory aPurchaseHistory) {
        purchaseHistory = aPurchaseHistory;
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

    /** Temporary value holder for group key fragment purchaseHistoryPurchaseId */
    private transient int tempPurchaseHistoryPurchaseId;

    /**
     * Gets the key fragment purchaseId for member purchaseHistory.
     * If this.purchaseHistory is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setPurchaseHistoryPurchaseId.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see PurchaseHistory
     */
    public int getPurchaseHistoryPurchaseId() {
        return (getPurchaseHistory() == null ? tempPurchaseHistoryPurchaseId : getPurchaseHistory().getPurchaseId());
    }

    /**
     * Sets the key fragment purchaseId from member purchaseHistory.
     * If this.purchaseHistory is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getPurchaseHistoryPurchaseId.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aPurchaseId New value for the key fragment
     * @see PurchaseHistory
     */
    public void setPurchaseHistoryPurchaseId(int aPurchaseId) {
        if (getPurchaseHistory() == null) {
            tempPurchaseHistoryPurchaseId = aPurchaseId;
        } else {
            getPurchaseHistory().setPurchaseId(aPurchaseId);
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
        if (this.getPurchaseHistoryPurchaseId() != that.getPurchaseHistoryPurchaseId()) {
            return false;
        }
        if (this.getStockDetailsStockInventoryId() != that.getStockDetailsStockInventoryId()) {
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
        i = getPurchaseHistoryPurchaseId();
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
        StringBuffer sb = new StringBuffer("[Feedback |");
        sb.append(" purchaseHistoryPurchaseId=").append(getPurchaseHistoryPurchaseId());
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
        ret.put("purchaseHistoryPurchaseId", Integer.valueOf(getPurchaseHistoryPurchaseId()));
        ret.put("stockDetailsStockInventoryId", Integer.valueOf(getStockDetailsStockInventoryId()));
        return ret;
    }

}
