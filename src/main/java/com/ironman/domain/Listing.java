package com.ironman.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author jsingh on 2013-06-18 at 11:36 PM
 */
@Entity
@Table(name = "LISTINGS")
@NamedQueries({
        @NamedQuery(name = "Listing.findListingsByListingStatus",
                query = "SELECT DISTINCT l FROM Listing l " +
                        "WHERE l.listingStatus = :listingStatus"),
        @NamedQuery(name = "Listing.findListingsByPrice",
                query = "SELECT DISTINCT l FROM Listing l " +
                        "WHERE l.listedPrice >= :priceGe " +
                        "AND l.listedPrice <= :priceLe"),
        @NamedQuery(name = "Listing.findListingsByBedrooms",
                query = "SELECT DISTINCT l FROM Listing l " +
                        "WHERE l.bedrooms = :bedrooms"),
        @NamedQuery(name = "Listing.findListingsByProvince",
                query = "SELECT DISTINCT l FROM Listing l " +
                        "WHERE l.province = :province"),
        @NamedQuery(name = "Listing.findListingsByListingCity",
                query = "SELECT DISTINCT l FROM Listing l " +
                        "WHERE l.city = :city"),
        @NamedQuery(name = "Listing.findListingsByListingPostalCode",
                query = "SELECT DISTINCT l FROM Listing l " +
                        "WHERE l.postalCode LIKE :postalCode"),
})
public class Listing extends BaseObject {

    @Id
    @Column(name = "LISTING_ID", unique = true, nullable = false)
    private long listingId;

    @Lob
    @Column(name = "PICTURE")
    private byte[] picture;

    @Column(name = "LISTED_PRICE", nullable = false)
    private BigDecimal listedPrice;

    @Column(name = "BEDROOMS", nullable = false)
    private float bedrooms;

    @Column(name = "BATHROOMS", nullable = false)
    private String bathrooms;

    @Column(name = "PROPERTY_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    @Column(name = "PROPERTY_TAX")
    private BigDecimal propertyTax;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "LISTING_STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private ListingStatus listingStatus;

    @Column(name = "PROVINCE")
    private String province;

    @Column(name = "CITY")
    private String city;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

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

    public float getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(float bedrooms) {
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
