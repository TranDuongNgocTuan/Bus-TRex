package com.iviettech.bus.controller;

import com.iviettech.bus.entity.BusesEntity;
import com.iviettech.bus.entity.BusstationEntity;
import com.iviettech.bus.entity.InfoTicket;
import com.iviettech.bus.entity.TicketEntity;
import com.iviettech.bus.repository.BusesRepository;
import com.iviettech.bus.repository.TimeTableScheduleRepository;
import com.iviettech.bus.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by tran on 20/08/2016.
 */
@Controller
public class ChooseChairController {

    @Autowired
    BusesRepository busesRepository;

    @Autowired
    TimeTableScheduleRepository timeTableScheduleRepository;

    @RequestMapping(value = "/choosechair")
    public String showTicketList(@RequestParam(name = "busesId") int busesId,
                                 @RequestParam(name = "timeTableId")int timeTableId,
                                 @ModelAttribute(value = "ticket") TicketEntity ticket,
                                 HttpSession session,
                                 Model model) {

        BusesEntity busesEntity = busesRepository.findOne(busesId);

        if (busesEntity == null){
            busesEntity = new BusesEntity();
            busesEntity.setDate(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            busesEntity.setTimeTableScheduleEntity(timeTableScheduleRepository.findOne(timeTableId));
        }

        List<TicketEntity> ticketEntityList = busesEntity.getTicketEntityList();

        List<String> seatChoosed = new ArrayList<>();
        for (TicketEntity ticketEntity : ticketEntityList) {
            String[] seatOfTicket = ticketEntity.getSeat().split("[ .,?!]+");
            for (String seat : seatOfTicket)
                seatChoosed.add(seat);
        }

        ticket.setBusesEntity(busesEntity);

        model.addAttribute("seatChoosed", seatChoosed);
        model.addAttribute("buses", busesEntity);
        model.addAttribute("ticket", ticket);

        return "choosechair";
    }
}
