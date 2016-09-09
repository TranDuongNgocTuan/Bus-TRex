package com.iviettech.bus.controller;

import com.iviettech.bus.entity.AdminEntity;
import com.iviettech.bus.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Admin on 8/27/2016.
 */
@Controller
public class LoginController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Login(Model model){
        AdminEntity adminEntity=new AdminEntity();
        model.addAttribute("adminEntity",adminEntity);
        return "login";
    }

//    @RequestMapping(value = "/admin", method = RequestMethod.POST)
//    public String Admin(Model model,@ModelAttribute("adminEntity") AdminEntity adminEntity){
//        if (adminEntity != null && adminEntity.getUsername() != null && adminEntity.getPassword() != null){
//            if ((adminEntity.getUsername().equals("tho")) && adminEntity.getPassword().equals("123")){
//                model.addAttribute("msg","welcome"+adminEntity.getUsername());
//                return "admin";
//            }else {
//                model.addAttribute("error","Username ho?c Passwprd không ?úng");
//                return "login";
//            }
//        }else {
//            model.addAttribute("error","Username ho?c Passwprd không ?úng");
//            return "login";
//        }
//    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String Admin(Model model,@ModelAttribute("adminEntity") AdminEntity adminEntity) {
        boolean test=adminService.checkAdmin(adminEntity.getUsername(),adminEntity.getPassword());
        if (test){
            return "admin";
        }else {
            String msg="username or pasword not corect";
            model.addAttribute("msg",msg);
            return "login";
        }
    }

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String admin(){
        return "admin";
    }
}
