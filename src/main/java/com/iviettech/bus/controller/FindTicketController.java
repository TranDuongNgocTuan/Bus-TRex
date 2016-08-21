package com.iviettech.bus.controller;

import com.iviettech.bus.entity.BusesEntity;
import com.iviettech.bus.entity.BusstationEntity;
import com.iviettech.bus.entity.InfoTicket;
import com.iviettech.bus.entity.ScheduleEntity;
import com.iviettech.bus.repository.BusesRepository;
import com.iviettech.bus.repository.BusstationRepository;
import com.iviettech.bus.repository.InfoTicketRepository;
import com.iviettech.bus.repository.ScheduleRepository;
import com.iviettech.bus.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class FindTicketController {

    @Autowired
    BusstationRepository busstationRepository;

    @Autowired
    BusesRepository busesRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    InfoTicketRepository infoTicketRepository;

    /**
     * This is method perform show schedule user find with departure ,arrival and departuretime201
     * @param model
     * @return
     */
    @RequestMapping(value = "/findticket")
    public String showTicketList(Model model) {
        BusstationEntity busstationEntityFrom = busstationRepository.findOne(1); // Form
        BusstationEntity busstationEntityTo = busstationRepository.findOne(2);   // To
        model.addAttribute("from", busstationEntityFrom);
        model.addAttribute("to", busstationEntityTo);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse("2016-08-20");
//            System.out.println(dateFormat.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ScheduleService scheduleService = new ScheduleService();

        List<InfoTicket> scheduleEntityList =
                infoTicketRepository.findAllInfoTicket(1, 2, new java.sql.Date(date.getTime()));

        model.addAttribute("scheduleList",scheduleEntityList);
        model.addAttribute("dayStartMove",new java.sql.Date(date.getTime()));

        return "findticket";
    }
}