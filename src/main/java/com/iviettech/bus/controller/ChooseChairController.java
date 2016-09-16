package com.iviettech.bus.controller;

import com.iviettech.bus.entity.*;
import com.iviettech.bus.repository.BusesRepository;
import com.iviettech.bus.repository.BusstationRepository;
import com.iviettech.bus.repository.TimeTableScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @Autowired
    BusstationRepository busstationRepository;

    @RequestMapping(value = "/choosechair")
    public String showTicketList(@RequestParam(name = "busesId") int busesId,
                                 @RequestParam(name = "timeTableId") int timeTableId,
                                 @RequestParam(name = "busstationDeparture") int busstationDeparture,
                                 @RequestParam(name = "busstationArrival") int busstationArrival,
                                 @RequestParam(name = "dayStartMove") String dayStartMove,
                                 @ModelAttribute(name = "ticket") TicketEntity ticket,
                                 HttpSession session,
                                 Model model) {

        BusesEntity busesEntity = busesRepository.findOne(busesId);
        TimeTableScheduleEntity timeTableScheduleEntity = timeTableScheduleRepository.findOne(timeTableId);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dayStartMove);
//            System.out.println(dateFormat.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (busesEntity == null) {
            busesEntity = new BusesEntity();
            busesEntity.setDate(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            busesEntity.setTimeTableScheduleEntity(timeTableScheduleEntity);
        }

        List<TicketEntity> ticketEntityList = busesEntity.getTicketEntityList();
        List<String> seatChoosed = new ArrayList<>();

        if (ticketEntityList != null) {
            for (TicketEntity ticketEntity : ticketEntityList) {
                String[] seatOfTicket = ticketEntity.getSeat().split("[ .,?!]+");
                for (String seat : seatOfTicket)
                    seatChoosed.add(seat);
            }
        }

        ticket.setBusstationEntityArrival(busstationRepository.findOne(busstationArrival));
        ticket.setBusstationEntityDeparture(busstationRepository.findOne(busstationDeparture));

        model.addAttribute("seatChoosed", seatChoosed);
        model.addAttribute("buses", busesEntity);
        model.addAttribute("ticket", ticket);
        model.addAttribute("timeTable", timeTableScheduleEntity);
        session.setAttribute("ticket", ticket);
        session.setAttribute("dayStartMove", new java.sql.Date(date.getTime()));

        return "choosechair";
    }
}
