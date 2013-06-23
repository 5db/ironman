package com.ironman.repository;

import com.ironman.domain.Listing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.Date;

/**
 * @author jsingh on 2013-06-20 at 2:29 PM
 */
public interface ListingRepository extends JpaRepository<Listing, Long>{

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value = "true") })
    Page<Listing> findListingByListingId(long listingId, Pageable pageable);

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value = "true") })
    Page<Listing> findByBathroomsLessThan(float bathrooms, Pageable pageable);
}
