package com.iviettech.bus.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iviettech.bus.entity.*;
import com.iviettech.bus.repository.TicketRepository;
import com.iviettech.bus.utils.AESCrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by tran on 06/09/2016.
 */
@Controller
public class ScanTicketController {

    @Autowired
    AESCrypter aesCrypter;

    @Autowired
    TicketRepository ticketRepository;

    @RequestMapping(value = "/scanticket")
    public String showTicketList() {
        return "qrcodereader";
    }

    @RequestMapping(value = "/scanticket/codeticket", method = RequestMethod.GET ,produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String showTicketQrCode(HttpServletRequest request) throws GeneralSecurityException {

        String code = request.getParameter("code");

//        String key = "TTY6I9^hQuo!a1n0";
//        String iv =  "Iay63!2Uy*)sQZhn"; // Initialization vector
//        String codedecrypt = aesCrypter.decrypt(code, key, iv);

        ObjectMapper mapper = null;
        Map<String, String> hash = null;

        TicketEntity ticketEntity = ticketRepository.findByCodeTicket(code);

        if (ticketEntity != null) {

            mapper = new ObjectMapper();
            hash = new HashMap<>();
            hash.put("exist", "1");
            hash.put("fullName", ticketEntity.getFullName());
            hash.put("gmail", ticketEntity.getGmail());
            hash.put("bookTime", String.valueOf(ticketEntity.getBookTime()));
            hash.put("numberphone", String.valueOf(ticketEntity.getNumberphone()));
            if (ticketEntity.getStatus() == 1) {
                hash.put("status", "Đã Thanh Toán");
            } else {
                hash.put("status", "Chưa thanh toán");
            }
            hash.put("seat", ticketEntity.getSeat());
            hash.put("codeTicket", ticketEntity.getCodeTicket());
            hash.put("totalPrice", String.valueOf(ticketEntity.getTotalprice()));
            hash.put("from", ticketEntity.getBusstationEntityDeparture().getCity());
            hash.put("fromTime", String.valueOf(ticketEntity.getBusesEntity().getTimeTableScheduleEntity().getDepartureTime()));
            hash.put("to", ticketEntity.getBusstationEntityArrival().getCity());
            hash.put("toTime", String.valueOf(ticketEntity.getBusesEntity().getTimeTableScheduleEntity().getArriveTime()));
            hash.put("dayMove", String.valueOf(ticketEntity.getBusesEntity().getDate()));
            hash.put("departure", ticketEntity.getBusstationEntityDeparture().getAddress());
            hash.put("arrival", ticketEntity.getBusstationEntityArrival().getAddress());
            hash.put("busService", ticketEntity.getBusesEntity().getTimeTableScheduleEntity().getScheduleEntity().getBusServicesEntity().getName());
        }
        else{
            mapper = new ObjectMapper();
            hash = new HashMap<>();
            hash.put("exist", "0");
        }

        String ajaxResponse = "";
        try {
            ajaxResponse = mapper.writeValueAsString(hash);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ajaxResponse;
    }

    @RequestMapping(value = "/scanticket/codetickettaixe", method = RequestMethod.GET ,produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String showTicketCodeTaiXe(HttpServletRequest request) throws GeneralSecurityException {

        String code = request.getParameter("code");
        if (code == null){
          code = "";
        }
//        String key = "TTY6I9^hQuo!a1n0";
//        String iv =  "Iay63!2Uy*)sQZhn"; // Initialization vector
//        String codedecrypt = aesCrypter.decrypt(code, key, iv);

        ObjectMapper mapper = null;
        Map<String, String> hash = null;

        TicketEntity ticketEntity = ticketRepository.findByCodeTicket(code);

        Date date = new Date();

        if (ticketEntity != null
                && ((new java.sql.Date(date.getTime()).after(new java.sql.Date(ticketEntity.getBookTime().getTime())))
                || (new java.sql.Date(date.getTime()).equals(new java.sql.Date(ticketEntity.getBookTime().getTime()))))) {

            mapper = new ObjectMapper();
            hash = new HashMap<>();
            hash.put("exist", "1");
            hash.put("fullName", ticketEntity.getFullName());
            hash.put("gmail", ticketEntity.getGmail());
            hash.put("bookTime", String.valueOf(ticketEntity.getBookTime()));
            hash.put("numberphone", String.valueOf(ticketEntity.getNumberphone()));
            if (ticketEntity.getStatus() == 1) {
                hash.put("status", "Đã Thanh Toán");
            } else {
                hash.put("status", "Chưa thanh toán");
            }
            hash.put("seat", ticketEntity.getSeat());
            hash.put("codeTicket", ticketEntity.getCodeTicket());
            hash.put("totalPrice", String.valueOf(ticketEntity.getTotalprice()));
            hash.put("from", ticketEntity.getBusstationEntityDeparture().getCity());
            hash.put("fromTime", String.valueOf(ticketEntity.getBusesEntity().getTimeTableScheduleEntity().getDepartureTime()));
            hash.put("to", ticketEntity.getBusstationEntityArrival().getCity());
            hash.put("toTime", String.valueOf(ticketEntity.getBusesEntity().getTimeTableScheduleEntity().getArriveTime()));
            hash.put("dayMove", String.valueOf(ticketEntity.getBusesEntity().getDate()));
            hash.put("departure", ticketEntity.getBusstationEntityDeparture().getAddress());
            hash.put("arrival", ticketEntity.getBusstationEntityArrival().getAddress());
            hash.put("busService", ticketEntity.getBusesEntity().getTimeTableScheduleEntity().getScheduleEntity().getBusServicesEntity().getName());
            hash.put("plan", ticketEntity.getBusesEntity().getTimeTableScheduleEntity().getBusEntity().getLicensePlate());

        }
        else{
            mapper = new ObjectMapper();
            hash = new HashMap<>();
            hash.put("exist", "0");
        }

        String ajaxResponse = "";
        try {
            ajaxResponse = mapper.writeValueAsString(hash);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ajaxResponse;
    }


}
