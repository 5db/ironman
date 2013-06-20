package com.ironman.service;

import com.ironman.domain.Listing;
import com.ironman.domain.ListingStatus;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author jsingh on 2013-06-19 at 2:20 PM
 */
@SuppressWarnings("unchecked")
@Service
public class ListingServiceImpl implements ListingService {

    private static Logger log = Logger.getLogger(ListingServiceImpl.class);

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Listing> getListingsByListingStatus(ListingStatus listingStatus) {
        return entityManager.createNamedQuery("Listing.findListingsByListingStatus")
                .setParameter("listingStatus", listingStatus).getResultList();
    }

    @Override
    public List<Listing> getListingsByPrice(BigDecimal priceGe, BigDecimal priceLe) {
        return entityManager.createNamedQuery("Listing.findListingsByPrice")
                .setParameter("priceGe", priceGe)
                .setParameter("priceLe", priceLe).getResultList();
    }

    @Override
    public List<Listing> getListingsByPriceAndCity(BigDecimal priceGe, BigDecimal priceLe, String city) {
        return  entityManager.createNamedQuery("Listing.findListingsByPriceAndCity")
                .setParameter("priceGe", priceGe)
                .setParameter("priceLe", priceLe)
                .setParameter("city", city).getResultList();
    }

    @Override
    public List<Listing> getListingsByCity(String city) {
        return entityManager.createNamedQuery("Listing.findListingsByCity")
                .setParameter("city", city).getResultList();
    }
}
