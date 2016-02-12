package com.zinkovich.controller;

import com.zinkovich.domain.Customer;
import com.zinkovich.service.CustomerService;
import com.zinkovich.service.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServicesController {

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public String getServices() {
        return "home/services";
    }

    @RequestMapping(value = "/services/decorative", method = RequestMethod.GET)
    public String getDecorative() {
        return "services/decorative";
    }

    @RequestMapping(value = "/services/retaining", method = RequestMethod.GET)
    public String getRetaining() {
        return "services/retaining";
    }
}