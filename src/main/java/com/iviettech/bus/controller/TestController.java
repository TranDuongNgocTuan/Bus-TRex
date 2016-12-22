package com.iviettech.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by tran on 20/08/2016.
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {
    @RequestMapping(method = RequestMethod.GET)
    public String test(@RequestParam(name = "a", required = false, defaultValue = "2") String a,
                       Model model) {
        if (a.equalsIgnoreCase("1")) {
            model.addAttribute("ticket", "111111");
            System.out.println(a);
        }
        else
            model.addAttribute("ticket", "222222");

        return "test";
    }
}
