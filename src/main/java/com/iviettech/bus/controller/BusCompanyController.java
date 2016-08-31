package com.iviettech.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Admin on 8/30/2016.
 */
@Controller
public class BusCompanyController {
    @RequestMapping(value = "/buscompany")
    public String buscompany(){
        return "buscompany";
    }
}
