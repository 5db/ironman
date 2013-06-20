package com.ironman.controller;

import com.ironman.domain.Listing;
import com.ironman.repository.ListingRepository;
import com.ironman.util.IronManUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jsingh on 2013-06-19 at 2:42 PM
 */
@Controller
@RequestMapping(value = IronManUtil.V1 + IronManUtil.LISTINGS)
public class ListingController {

    @Autowired
    ListingRepository listingRepository;

    private static Logger log = Logger.getLogger(ListingController.class);

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public PageResource<Listing> getListings(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size,
            @RequestParam(value = "po", required = false, defaultValue = "DESC") String po,
            @RequestParam(value = "pf", required = false, defaultValue = "dateCreated") String pf) {
        log.info("Serving GET " + IronManUtil.V1 + IronManUtil.LISTINGS);

        Sort sort = null;
        if(po.equals(Sort.Direction.DESC.name())) {
            sort = new Sort(Sort.Direction.DESC, pf);
        } else if(po.equals(Sort.Direction.ASC.name())) {
            sort = new Sort(Sort.Direction.ASC, pf);
        }

        Pageable pageable = new PageRequest(page, (size > 50 ? 50 : size), sort);
        Page<Listing> pageResult = listingRepository.findAll(pageable);

        return new PageResource<>(pageResult, "page", "size");
    }
}
