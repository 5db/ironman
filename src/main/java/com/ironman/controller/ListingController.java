package com.ironman.controller;

import com.ironman.domain.Listing;
import com.ironman.domain.ListingStatus;
import com.ironman.service.ListingService;
import com.ironman.util.IronManUtil;
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
            @RequestParam(value = "priceGe", required = true, defaultValue = "50000") BigDecimal priceGe,
            @RequestParam(value = "priceLe", required = true, defaultValue = "500000") BigDecimal priceLe) {
        log.info("Serving GET " + IronManUtil.V1 + IronManUtil.LISTINGS + "?priceGe=" + priceGe + "&priceLe=" + priceLe);
        return listingService.getListingsByPrice(priceGe, priceLe);
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody List<Listing> getListingsByBedrooms(
            @RequestParam(value = "bedrooms", required = true, defaultValue = "1") float bedrooms) {
        log.info("Serving GET " + IronManUtil.V1 + IronManUtil.LISTINGS + "?bedrooms=" + bedrooms);
        return listingService.getListingsByBedrooms(bedrooms);
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody List<Listing> getListingsByListingStatus(
            @RequestParam(value = "status", required = true, defaultValue = "AVAILABLE") ListingStatus listingStatus) {
        log.info("Serving GET " + IronManUtil.V1 + IronManUtil.LISTINGS + "?listingStatus=" + listingStatus);
        return listingService.getListingsByListingStatus(listingStatus);
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody List<Listing> getListingsByProvince(
            @RequestParam(value = "province", required = true, defaultValue = "ON") String province) {
        log.info("Serving GET " + IronManUtil.V1 + IronManUtil.LISTINGS + "?province=" + province);
        return listingService.getListingsByProvince(province);
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody List<Listing> getListingsByCity(
            @RequestParam(value = "city", required = true, defaultValue = "BRAMPTON") String city) {
        log.info("Serving GET " + IronManUtil.V1 + IronManUtil.LISTINGS + "?city=" + city);
        return listingService.getListingsByCity(city);
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody List<Listing> getListingsByPostalCode(
            @RequestParam(value = "postalCode", required = true) String postalCode) {
        log.info("Serving GET " + IronManUtil.V1 + IronManUtil.LISTINGS + "?postalCode=" + postalCode);
        return listingService.getListingsByPostalCode(postalCode.substring(0, 3));
    }
}
