package com.ironman.domain;

import java.math.BigDecimal;

/**
 * @author jsingh on 2013-06-18 at 11:36 PM
 */
public class Listing extends BaseObject {

    private long listingId;

    private byte[] picture;

    private BigDecimal listedPrice;

    private String bedrooms;

    private String bathrooms;

    private PropertyType propertyType;

    private BigDecimal propertyTax;

    private String description;

    private ListingStatus listingStatus;

    public long getListingId() {
        return listingId;
    }

    public void setListingId(long listingId) {
        this.listingId = listingId;
    }

    public BigDecimal getListedPrice() {
        return listedPrice;
    }

    public void setListedPrice(BigDecimal listedPrice) {
        this.listedPrice = listedPrice;
    }

    public String getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(String bedrooms) {
        this.bedrooms = bedrooms;
    }

    public String getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(String bathrooms) {
        this.bathrooms = bathrooms;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public BigDecimal getPropertyTax() {
        return propertyTax;
    }

    public void setPropertyTax(BigDecimal propertyTax) {
        this.propertyTax = propertyTax;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ListingStatus getListingStatus() {
        return listingStatus;
    }

    public void setListingStatus(ListingStatus listingStatus) {
        this.listingStatus = listingStatus;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
