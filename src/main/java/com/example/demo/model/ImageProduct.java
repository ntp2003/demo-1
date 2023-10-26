// Generated with g9.

package com.example.demo.model;

import java.io.Serializable;
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
public class ImageProduct implements Serializable {

    /** Primary key. */
    protected static final String PK = "imageId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ImageID", unique=true, nullable=false, precision=10)
    private int imageId;
    @Column(name="Image")
    private String image;
    @ManyToOne(optional=false)
    @JoinColumn(name="ProductCategoryID", nullable=false)
    private ProductCategory productCategory;

    /** Default constructor. */
    public ImageProduct() {
        super();
    }

    /**
     * Access method for imageId.
     *
     * @return the current value of imageId
     */
    public int getImageId() {
        return imageId;
    }

    /**
     * Setter method for imageId.
     *
     * @param aImageId the new value for imageId
     */
    public void setImageId(int aImageId) {
        imageId = aImageId;
    }

    /**
     * Access method for image.
     *
     * @return the current value of image
     */
    public String getImage() {
        return image;
    }

    /**
     * Setter method for image.
     *
     * @param aImage the new value for image
     */
    public void setImage(String aImage) {
        image = aImage;
    }

    /**
     * Access method for productCategory.
     *
     * @return the current value of productCategory
     */
    public ProductCategory getProductCategory() {
        return productCategory;
    }

    /**
     * Setter method for productCategory.
     *
     * @param aProductCategory the new value for productCategory
     */
    public void setProductCategory(ProductCategory aProductCategory) {
        productCategory = aProductCategory;
    }

    /**
     * Compares the key for this instance with another ImageProduct.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class ImageProduct and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof ImageProduct)) {
            return false;
        }
        ImageProduct that = (ImageProduct) other;
        if (this.getImageId() != that.getImageId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another ImageProduct.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ImageProduct)) return false;
        return this.equalKeys(other) && ((ImageProduct)other).equalKeys(this);
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
        i = getImageId();
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
        StringBuffer sb = new StringBuffer("[ImageProduct |");
        sb.append(" imageId=").append(getImageId());
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
        ret.put("imageId", Integer.valueOf(getImageId()));
        return ret;
    }

}
