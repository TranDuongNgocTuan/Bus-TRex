package com.iviettech.bus.controller;

import com.iviettech.bus.entity.BusesEntity;
import com.iviettech.bus.entity.BusstationEntity;
import com.iviettech.bus.entity.InfoTicket;
import com.iviettech.bus.entity.TicketEntity;
import com.iviettech.bus.repository.BusesRepository;
import com.iviettech.bus.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tran on 20/08/2016.
 */
@Controller
public class ChooseChairController {

    @Autowired
    BusesRepository busesRepository;

    @RequestMapping(value = "/choosechair")
    public String showTicketList(/*@RequestParam(name = "fullName") String fullName,
                                 @RequestParam(name = "numberPhone") String numberPhone,
                                 @RequestParam(name = "gmail") String gmail,
                                 @RequestParam(name = "gmail") int busesId,*/
                                 Model model) {

        BusesEntity busesEntity = busesRepository.findOne(1);
        List<TicketEntity> ticketEntityList = busesEntity.getTicketEntityList();
        List<String> seatChoosed = new ArrayList<>();
        for (TicketEntity ticket : ticketEntityList){
            String[] seatOfTicket = ticket.getSeat().split("[ .,?!]+");
            for (String seat : seatOfTicket)
            seatChoosed.add(seat);
        }

        model.addAttribute("seatChoosed", seatChoosed);
        model.addAttribute("buses", busesEntity);
        return "choosechair";
    }
}
