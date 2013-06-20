package com.ironman.repository;

import com.ironman.domain.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jsingh on 2013-06-20 at 2:29 PM
 */
public interface ListingRepository extends JpaRepository<Listing, Long>{
}
