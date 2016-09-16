package com.iviettech.bus.controller;

import com.iviettech.bus.entity.*;
import com.iviettech.bus.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tran on 12/09/2016.
 */
@Controller
public class StaffController {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TimeTableScheduleRepository timeTableScheduleRepository;

    @Autowired
    BusRepository busRepository;

    @Autowired
    BusesRepository busesRepository;

    @Autowired
    TaiXeRepository taiXeRepository;


    @RequestMapping(value = "/loginstaff")
    public String loginStaff(@RequestParam(value = "username", required = false, defaultValue = "") String username,
                             @RequestParam(value = "password", required = false, defaultValue = "") String password,
                             HttpSession session){

        TaiXeEntity taiXeEntity = taiXeRepository.findByUsernameAndPassword(username, password);
        if (taiXeEntity!=null) {
            session.setAttribute("taixe", taiXeEntity);
            return "redirect:/adminstaff";
        }
        else
            return "loginstaff";
    }

    @RequestMapping(value = "/adminstaff")
    public String adminStaff(HttpSession session){
        return "starter";
    }

    @RequestMapping(value = "/showticketstaff")
    public String showTicketStaff(Model model,
                                  HttpSession session){
        Date date = new Date();

//        TaiXeEntity taiXeEntity = (TaiXeEntity) session.getAttribute("taixe");
        BusEntity busEntity = busRepository.findOne(1);
        List<TicketEntity> ticketEntityListShow = new ArrayList<>();

        for (TimeTableScheduleEntity timeTable : busEntity.getTimeTableScheduleEntityList()){
            BusesEntity busesEntity = busesRepository.findByDateAndTimeTableScheduleEntityId(new java.sql.Date(date.getTime()), timeTable.getId());
            if (busesEntity != null){
                List<TicketEntity> ticketEntityList = busesEntity.getTicketEntityList();
                ticketEntityListShow.addAll(ticketEntityList);
            }
        }

        model.addAttribute("ticketListShow", ticketEntityListShow);

        return "tableticket";
    }

//    @RequestMapping(value = "/paystaff")
//    public String actionPaymentStaff(){ return "staffscanticket"; }

//    @RequestMapping(value = "/adminstaff")
//    public String paymentScanStaff(){ return ""; }

    @RequestMapping(value = "/adminscanstaff")
    public String paymentStaff(){ return "staffscanticket"; }

    @RequestMapping(value = "/signout")
    public String singOut(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        session.invalidate();
//        session.setAttribute("taixe", null);
        return "starter";
    }
}
