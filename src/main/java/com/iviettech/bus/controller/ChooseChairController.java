package com.iviettech.bus.controller;

import com.iviettech.bus.entity.BusstationEntity;
import com.iviettech.bus.entity.InfoTicket;
import com.iviettech.bus.service.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by tran on 20/08/2016.
 */
@Controller
public class ChooseChairController {
    @RequestMapping(value = "/choosechair", method = RequestMethod.POST)
    public String showTicketList(@RequestParam(name = "fullName") String fullName,
                                 @RequestParam(name = "numberPhone") String numberPhone,
                                 @RequestParam(name = "gmail") String gmail,
                                 Model model) {


        return "choosechair";
    }
}
