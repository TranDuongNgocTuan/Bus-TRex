package com.iviettech.bus.controller;

import com.iviettech.bus.entity.BusesEntity;
import com.iviettech.bus.entity.BusstationEntity;
import com.iviettech.bus.entity.ScheduleEntity;
import com.iviettech.bus.repository.BusesRepository;
import com.iviettech.bus.repository.BusstationRepository;
import com.iviettech.bus.repository.ScheduleRepository;
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
public class ScheduleShowController {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    BusstationRepository busstationRepository;

    @Autowired
    BusesRepository busesRepository;

    /**
     * This is method perform show schedule user find with departure ,arrival and departuretime201
     * @param model
     * @return
     */
    @RequestMapping(value = "/schedule")
    public String showTicketList(Model model) {
        BusstationEntity busstationEntityFrom = busstationRepository.findOne(1); // Form
        BusstationEntity busstationEntityTo = busstationRepository.findOne(1);   // To
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date date = null;
        try {
            date = dateFormat.parse("2016-08-18");
//            System.out.println(dateFormat.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<ScheduleEntity> scheduleEntityList =
                scheduleRepository.findByFromAndToAndDepartureTimeEqual(busstationEntityFrom.getId(), busstationEntityTo.getId(), new java.sql.Date(date.getTime()) );
        model.addAttribute("TicketList", scheduleEntityList);

        List<BusesEntity> busesEntityList =
                busesRepository.findByScheduleEntityId(scheduleEntityList.get(0).getId());

        System.out.println(busesEntityList.get(0).getBusEntity());

        return "findticket";
    }
}
