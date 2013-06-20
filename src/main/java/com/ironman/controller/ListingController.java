package com.ironman.controller;

import com.ironman.domain.Listing;
import com.ironman.domain.ListingStatus;
import com.ironman.service.ListingService;
import com.ironman.util.IronManUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author jsingh on 2013-06-19 at 2:42 PM
 */
@Controller
@RequestMapping(value = IronManUtil.V1 + IronManUtil.LISTINGS)
public class ListingController {

    private static Logger log = Logger.getLogger(ListingController.class);

    ListingService listingService;

    @Autowired
    public void setListingService(ListingService listingService) {
        this.listingService = listingService;
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody List<Listing> getListingsByPrice(
            @RequestParam(value = "priceGe", required = false) BigDecimal priceGe,
            @RequestParam(value = "priceLe", required = false) BigDecimal priceLe,
            @RequestParam(value = "status", required = false) ListingStatus status,
            @RequestParam(value = "city", required = false, defaultValue = "BRAMPTON") String city) {
        log.info("Serving GET " + IronManUtil.V1 + IronManUtil.LISTINGS + IronManUtil.PRICE);
        List<Listing> listings = null;

        if(priceGe != null && !priceGe.equals(BigDecimal.ZERO) && priceLe !=  null && !priceLe.equals(BigDecimal.ZERO)) {
            if(StringUtils.isNotEmpty(city)) {
                listings = listingService.getListingsByPriceAndCity(priceGe, priceLe, city);
            } else {
                listings = listingService.getListingsByPrice(priceGe, priceLe);
            }
        } else if(StringUtils.isNotEmpty(status.name())) {
            listings = listingService.getListingsByListingStatus(status);
        } else if (StringUtils.isNotEmpty(city)) {
            listings = listingService.getListingsByCity(city);
        }

        return listings;
    }
}
