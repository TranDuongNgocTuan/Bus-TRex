package com.iviettech.bus.controller;

import com.iviettech.bus.entity.*;
import com.iviettech.bus.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tran on 12/09/2016.
 */
@Controller
public class StaffController {

    @Autowired
    TaiXeRepository taiXeRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TimeTableScheduleRepository timeTableScheduleRepository;

    @Autowired
    BusRepository busRepository;

    @Autowired
    BusesRepository busesRepository;


    @RequestMapping(value = "/loginstaff")
    public String loginStaff(){
        return "loginstaff";
    }

    @RequestMapping(value = "/adminstaff")
    public String adminStaff(){ return "starter"; }

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
}
