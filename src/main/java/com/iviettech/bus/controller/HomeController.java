package com.iviettech.bus.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Admin on 8/21/2016.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/home")
    public String Home(){
        return "home";
    }
}
