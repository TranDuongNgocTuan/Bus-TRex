package com.iviettech.bus.controller;

import com.iviettech.bus.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tran on 08/09/2016.
 */
@Component
public class ScheduleTicketController {

    @Autowired
    TicketRepository ticketRepository;

    @Scheduled(fixedDelay = 7200000, initialDelay = 30 * 1000)
    public void checkTickOverTime(){
        Date date = new Date();
        ticketRepository.deleteByStatus(date);
    }
}
