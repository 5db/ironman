package com.ironman.controller;

import com.ironman.util.IronManUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author jsingh on 6/7/13 at 1:41 PM
 */
@Controller
@RequestMapping(value = IronManUtil.V1)
public class HealthMonitorController {

    @RequestMapping(value = IronManUtil.HEALTH, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void helpIronMan() { }

}
