package com.iviettech.bus.controller;

import com.iviettech.bus.entity.BusesEntity;
import com.iviettech.bus.entity.PromotionTimeEntity;
import com.iviettech.bus.entity.TicketEntity;
import com.iviettech.bus.entity.TimeTableScheduleEntity;
import com.iviettech.bus.repository.*;
import com.iviettech.bus.utils.AESCrypter;
import com.iviettech.bus.utils.MailUtilGmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.security.GeneralSecurityException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by tran on 29/08/2016.
 */
@Controller
public class TransferController {

    @Autowired
    TimeTableScheduleRepository timeTableScheduleRepository;

    @Autowired
    StatusBusesRepository statusBusesRepository;

    @Autowired
    BusesRepository busesRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    AESCrypter aesCrypter;

    @Autowired
    MailUtilGmail mailUtilGmail;

    @Autowired
    PromotionTimeRepository promotionTimeRepository;

    @RequestMapping(value = "/transfer")
    public String transfer(@RequestParam(value = "timeTableId") int timeTableId,
                           @ModelAttribute(value = "ticket") TicketEntity ticket,
                           HttpSession session,
                           Model model) {

        Date dateStartMove = (Date) session.getAttribute("dayStartMove");
        TimeTableScheduleEntity timeTableScheduleEntity = timeTableScheduleRepository.findOne(timeTableId);
        PromotionTimeEntity promotionTimeEntity = promotionTimeRepository.findByScheduleEntityIdAndStartAndEnd(timeTableScheduleEntity.getScheduleEntity().getId(), dateStartMove);

        TicketEntity ticketSession = (TicketEntity) session.getAttribute("ticket");
        ticketSession.setSeat(ticket.getSeat());
        ticketSession.setNumberSeats(ticket.getNumberSeats());
        ticketSession.setTotalprice(ticket.getTotalprice()-ticket.getTotalprice()*promotionTimeEntity.getPromotionEntity().getSale()/100);

        model.addAttribute("timeTableTicket", timeTableScheduleEntity);
        model.addAttribute("ticket", ticketSession);
        model.addAttribute("dayStartMove", session.getAttribute("dayStartMove"));
        model.addAttribute("promotion", promotionTimeEntity);
        session.setAttribute("ticket", ticketSession);
        session.setAttribute("timeTableTicket", timeTableScheduleEntity);

        return "transfer";
    }

    @RequestMapping(value = "/postpaid")
    public String postPaid(HttpSession session) throws GeneralSecurityException {

        TicketEntity ticketEntitySession = (TicketEntity) session.getAttribute("ticket");
        TimeTableScheduleEntity timeTableScheduleEntity = (TimeTableScheduleEntity) session.getAttribute("timeTableTicket");
        Date dateStartMove = (Date) session.getAttribute("dayStartMove");

        BusesEntity busesEntity = busesRepository.findByDateAndTimeTableScheduleEntityId(dateStartMove, timeTableScheduleEntity.getId());

        if (busesEntity == null){
            busesEntity = new BusesEntity();
            busesEntity.setDate(new java.sql.Date(dateStartMove.getTime()));
            busesEntity.setTimeTableScheduleEntity((TimeTableScheduleEntity) session.getAttribute("timeTableTicket"));
            busesEntity.setStatusBusesEntity(statusBusesRepository.findOne(1));
            busesRepository.save(busesEntity);
        }

        ticketEntitySession.setBookTime(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
        ticketEntitySession.setBusesEntity(busesEntity);

        String text = ticketEntitySession.getBookTime().toString()+"-"+ticketEntitySession.getGmail();
        String key = "TTY6I9^hQuo!a1n0";
        String iv =  "Iay63!2Uy*)sQZhn"; // Initialization vector
        String encryptedCode = aesCrypter.encrypt(text, key, iv);
        ticketEntitySession.setCodeTicket(encryptedCode);

        ticketRepository.save(ticketEntitySession);

        session.invalidate();

        String message2="";
        try {
            String body = "<h1 style='color:red;'> Dear "+ticketEntitySession.getFullName()+" </h1>";
            body += "<h2>Đây là vé của bạn</h2>";
            mailUtilGmail.sendEmail(ticketEntitySession.getGmail(), "conos.team@gmail.com", "New Password", body, ticketEntitySession ,true);
        } catch (Exception ex) {
            System.out.println("Error : " + ex);
        }
        return "redirect:";
    }

    @RequestMapping(value = "/onlinepayment")
    public String onlinePayment(HttpSession session){
        return "";
    }
}
