package com.iviettech.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by tran on 29/08/2016.
 */
@Controller
public class TransferController {

    @RequestMapping(value = "/transfer")
    public String transfer(/*@RequestParam(name = "") */){
        return "transfer";
    }
}
