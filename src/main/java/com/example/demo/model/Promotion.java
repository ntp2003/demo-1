// Generated with g9.

package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class Promotion implements Serializable {

    /** Primary key. */
    protected static final String PK = "promotionId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PromotionID", unique=true, nullable=false, precision=10)
    private int promotionId;
    @Column(name="PromotionName", nullable=false, length=100)
    private String promotionName;
    @Column(name="StartTime", nullable=false)
    private LocalDate startTime;
    @Column(name="EndTime", nullable=false)
    private LocalDate endTime;
    @Column(name="Banner", nullable=false)
    private String banner;
    @OneToMany(mappedBy="promotionDetailId.promotion")
    private Set<PromotionDetail> promotionDetail;

    /** Default constructor. */
    public Promotion() {
        super();
    }

    /**
     * Access method for promotionId.
     *
     * @return the current value of promotionId
     */
    public int getPromotionId() {
        return promotionId;
    }

    /**
     * Setter method for promotionId.
     *
     * @param aPromotionId the new value for promotionId
     */
    public void setPromotionId(int aPromotionId) {
        promotionId = aPromotionId;
    }

    /**
     * Access method for promotionName.
     *
     * @return the current value of promotionName
     */
    public String getPromotionName() {
        return promotionName;
    }

    /**
     * Setter method for promotionName.
     *
     * @param aPromotionName the new value for promotionName
     */
    public void setPromotionName(String aPromotionName) {
        promotionName = aPromotionName;
    }

    /**
     * Access method for startTime.
     *
     * @return the current value of startTime
     */
    public LocalDate getStartTime() {
        return startTime;
    }

    /**
     * Setter method for startTime.
     *
     * @param aStartTime the new value for startTime
     */
    public void setStartTime(LocalDate aStartTime) {
        startTime = aStartTime;
    }

    /**
     * Access method for endTime.
     *
     * @return the current value of endTime
     */
    public LocalDate getEndTime() {
        return endTime;
    }

    /**
     * Setter method for endTime.
     *
     * @param aEndTime the new value for endTime
     */
    public void setEndTime(LocalDate aEndTime) {
        endTime = aEndTime;
    }

    /**
     * Access method for banner.
     *
     * @return the current value of banner
     */
    public String getBanner() {
        return banner;
    }

    /**
     * Setter method for banner.
     *
     * @param aBanner the new value for banner
     */
    public void setBanner(String aBanner) {
        banner = aBanner;
    }

    /**
     * Access method for promotionDetail.
     *
     * @return the current value of promotionDetail
     */
    public Set<PromotionDetail> getPromotionDetail() {
        return promotionDetail;
    }

    /**
     * Setter method for promotionDetail.
     *
     * @param aPromotionDetail the new value for promotionDetail
     */
    public void setPromotionDetail(Set<PromotionDetail> aPromotionDetail) {
        promotionDetail = aPromotionDetail;
    }

    /**
     * Compares the key for this instance with another Promotion.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Promotion and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Promotion)) {
            return false;
        }
        Promotion that = (Promotion) other;
        if (this.getPromotionId() != that.getPromotionId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Promotion.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Promotion)) return false;
        return this.equalKeys(other) && ((Promotion)other).equalKeys(this);
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
        i = getPromotionId();
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
        StringBuffer sb = new StringBuffer("[Promotion |");
        sb.append(" promotionId=").append(getPromotionId());
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
        ret.put("promotionId", Integer.valueOf(getPromotionId()));
        return ret;
    }

}
