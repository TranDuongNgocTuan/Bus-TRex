package com.iviettech.bus.controller;

import com.iviettech.bus.entity.BusstationEntity;
import com.iviettech.bus.entity.ScheduleEntity;
import com.iviettech.bus.repository.BusesRepository;
import com.iviettech.bus.repository.BusstationRepository;
import com.iviettech.bus.repository.ScheduleRepository;
import com.iviettech.bus.repository.TicketRepository;
import com.iviettech.bus.service.ScheduleService;
import com.iviettech.bus.utils.TaiXeNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by tran on 08/09/2016.
 */
@Component
public class ScheduleController {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    BusesRepository busesRepository;

    @Scheduled(fixedDelay = 7200000, initialDelay = 30 * 1000)
    public void checkTickOverTime(){
        Date date = new Date();
        ticketRepository.deleteByStatus(date);
    }
}
