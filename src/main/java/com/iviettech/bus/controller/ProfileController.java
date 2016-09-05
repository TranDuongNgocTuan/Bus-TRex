package com.iviettech.bus.controller;

import com.iviettech.bus.entity.AdminEntity;
import com.iviettech.bus.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Admin on 8/30/2016.
 */
@Controller
public class ProfileController {


    @RequestMapping(value = "/profile")
    public String profile(Model model){
        model.addAttribute("admin",new AdminEntity());
        return "profile";
    }



    @RequestMapping(value = "/change")
    public String change(){
        return "changepass";
    }
}

