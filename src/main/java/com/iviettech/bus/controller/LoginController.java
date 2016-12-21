package com.iviettech.bus.controller;

import com.iviettech.bus.entity.AdminEntity;
import com.iviettech.bus.entity.BusServicesEntity;
import com.iviettech.bus.service.AdminService;
import com.iviettech.bus.service.ProfileService;
import com.iviettech.bus.utils.TaiXeNotFound;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@Controller
public class LoginController {
    @Autowired
    ProfileService profileService;

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Login(Model model, HttpSession session) {
        AdminEntity adminEntity = new AdminEntity();
        model.addAttribute("adminEntity", adminEntity);
        return "login";
    }

//    @RequestMapping(value = "/admin", method = RequestMethod.POST)
//    public String Admin(Model model,@ModelAttribute("adminEntity") AdminEntity adminEntity){
//        if (adminEntity != null && adminEntity.getUsername() != null && adminEntity.getPassword() != null){
//            if ((adminEntity.getUsername().equals("tho")) && adminEntity.getPassword().equals("123")){
//                model.addAttribute("msg","welcome"+adminEntity.getUsername());
//                return "admin";
//            }else {
//                model.addAttribute("error","Username ho?c Passwprd kh�ng ?�ng");
//                return "login";
//            }
//        }else {
//            model.addAttribute("error","Username ho?c Passwprd kh�ng ?�ng");
//            return "login";
//        }
//    }

    @RequestMapping(value = "/admin")
    public String admin(Model model/*, @ModelAttribute("adminEntity") AdminEntity adminEntity*/, HttpSession session
                        ,@RequestParam(name = "username", required = false, defaultValue = "")String name
                        ,@RequestParam(name = "password", required = false, defaultValue = "")String password) {
        AdminEntity test = adminService.checkAdmin(name, password);
        AdminEntity adminEntitySession = (AdminEntity) session.getAttribute("adminEntity");
        if (adminEntitySession != null) {
            return "admin";
        } else if (test != null) {
            model.addAttribute("adminEntity", test);
            session.setAttribute("adminEntity", test);
            return "admin";
        } else {
            String msg = "username or pasword not corect";
            model.addAttribute("msg", msg);
            return "login";
        }
    }

    @RequestMapping(value = "/profile")
    public String profile(Model model,HttpSession session,
                          @RequestParam(name = "username", required = false, defaultValue = "")String name,
                          @RequestParam(name = "password", required = false, defaultValue = "")String password){
        AdminEntity adminEntity= (AdminEntity) session.getAttribute("adminEntity");
        model.addAttribute("admin",adminEntity);
        return "profile";
    }

    @RequestMapping(value="/profile/edit/{id}", method=RequestMethod.GET)
    public ModelAndView edit(@PathVariable Integer id){
        ModelAndView mav=new ModelAndView("editprofile");
        AdminEntity adminEntity=profileService.findById(id);
        mav.addObject("admin", adminEntity);
        return mav;
    }

    @RequestMapping(value="/profile/edit/{id}", method=RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute @Validated AdminEntity adminEntity,BindingResult result,@PathVariable Integer id,final RedirectAttributes redirectAttributes) throws TaiXeNotFound {
        if (result.hasErrors())
            return new ModelAndView("editprofile");
        ModelAndView mav=new ModelAndView("redirect:/profile");
        String message="successfully updated.";
        profileService.update(adminEntity);
        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

//    @RequestMapping(value = "/logout",method = RequestMethod.GET)
//    public String logout(HttpSession session){
//        session.invalidate();
//        return "redirect:/login";
//    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
//        Authentication authentication= SecurityContextHolder.getContext()
//                .getAuthentication();
//        if (authentication!=null){
//            new SecurityContextLogoutHandler().logout(request,response,authentication);
//        }
        session.invalidate();

        return "redirect:"+request.getHeader("Referer");
    }
}
