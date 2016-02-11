package com.zinkovich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jrzinkovich on 2/10/16.
 */

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "home/index";
    }

    @RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
    public String aboutUs() {
        return "home/aboutUs";
    }

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public String services() {
        return "home/services";
    }

}
