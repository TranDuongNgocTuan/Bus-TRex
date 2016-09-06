package com.iviettech.bus.controller;

import com.iviettech.bus.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by tran on 06/09/2016.
 */
@Controller
public class ScanTicketController {
    @RequestMapping(value = "/scanticket")
    public String showTicketList() {
        return "qrcodereader";
    }
}
