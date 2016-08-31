package com.iviettech.bus.controller;

import com.iviettech.bus.entity.AdminEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Admin on 8/30/2016.
 */
@Controller
public class ProfileController {
    @RequestMapping(value = "/profile")
    public String profile(Model model){
        AdminEntity adminEntity1=new AdminEntity();
        model.addAttribute("adminEntity1",adminEntity1);
        return "profile";
    }
}
