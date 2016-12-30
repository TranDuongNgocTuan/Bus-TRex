package com.iviettech.bus.controller;

import com.iviettech.bus.entity.*;
import com.iviettech.bus.repository.BusstationRepository;
import com.iviettech.bus.repository.InfoTicketRepository;
import com.iviettech.bus.repository.ScheduleRepository;
import com.iviettech.bus.repository.TimeTableScheduleRepository;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class LoginController {
    @Autowired
    ProfileService profileService;

    @Autowired
    AdminService adminService;

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    InfoTicketRepository infoTicketRepository;

    @Autowired
    BusstationRepository busstationRepository;

    @Autowired
    TimeTableScheduleRepository timeTableScheduleRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Login(Model model, HttpSession session) {
        AdminEntity adminEntity = new AdminEntity();
        model.addAttribute("adminEntity", adminEntity);
        return "login";
    }


    @RequestMapping(value = "/admin")
    public String admin(Model model,HttpSession session,HttpServletRequest request
                        ,@RequestParam(name = "username", required = false, defaultValue = "")String name
                        ,@RequestParam(name = "password", required = false, defaultValue = "")String password) {
        AdminEntity test = adminService.checkAdmin(name, password);
//        TicketEntity ticketEntity=new TicketEntity();
//        BusstationEntity busstationEntityFrom = busstationRepository.findByCity(ticketEntity.getBusstationEntityDeparture().getCity()); // Form
//        BusstationEntity busstationEntityTo = busstationRepository.findByCity(ticketEntity.getBusstationEntityArrival().getCity());   // To
//        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//        Date date = null;
//        try {
//            date = dateFormat.parse(String.valueOf(ticketEntity.getBusesEntity().getDate()));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        assert date != null;
//        List<InfoTicket> scheduleEntityList =
//                infoTicketRepository.findAllInfoTicket(busstationEntityFrom.getId(), busstationEntityTo.getId(), new java.sql.Date(date.getTime()));

        List<TimeTableScheduleEntity> timeTableScheduleEntities= (List<TimeTableScheduleEntity>) timeTableScheduleRepository.findAll();
        AdminEntity adminEntitySession = (AdminEntity) session.getAttribute("adminEntity");

        if(adminEntitySession !=null){
            return "admin";
        } else if (test != null) {
            model.addAttribute("adminEntity", test);
            session.setAttribute("adminEntity", test);
            model.addAttribute("tableschedule", timeTableScheduleEntities);
//            model.addAttribute("ticket",scheduleEntityList);
            return "admin";
        }
        else{
            String msg = "Incorrect username or password!";
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
    public String logout(HttpServletRequest request, HttpServletResponse response,Model model,HttpSession session) {

        request.getSession().removeAttribute("adminEntity");
//        session.removeAttribute("adminEntity");
        String msg = "Logout successfully";
        model.addAttribute("msg", msg);
        return "login";


//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/login?logout";
    }
}
