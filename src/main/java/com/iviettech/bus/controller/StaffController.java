package com.iviettech.bus.controller;

import com.iviettech.bus.entity.AdminEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tran on 12/09/2016.
 */
@Controller
public class StaffController {

    @RequestMapping(value = "/loginstaff")
    public String loginStaff(){
        return "loginstaff";
    }


}
