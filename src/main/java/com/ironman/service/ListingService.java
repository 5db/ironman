package com.ironman.service;

import com.ironman.domain.Listing;
import com.ironman.domain.ListingStatus;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author jsingh on 2013-06-19 at 2:20 PM
 */
public interface ListingService {
    List<Listing> getListingsByListingStatus(ListingStatus listingStatus);

    List<Listing> getListingsByPrice(BigDecimal priceGe, BigDecimal priceLe);

    List<Listing> getListingsByPriceAndCity(BigDecimal priceGe, BigDecimal priceLe, String city);

    List<Listing> getListingsByCity(String city);
}
