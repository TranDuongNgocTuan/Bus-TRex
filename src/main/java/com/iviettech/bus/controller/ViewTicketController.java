package com.iviettech.bus.controller;

/**
 * Created by tran on 14/09/2016.
 */
import com.iviettech.bus.entity.TicketEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * A Spring controller that allows the users to download a PDF document
 * generated by the iText library.
 *
 * @author www.codejava.net
 *
 */
@Controller
public class ViewTicketController {

    /**
     * Handle request to download a PDF document
     */
    @RequestMapping(value = "/downloadPDFPay", method = RequestMethod.GET)
    public ModelAndView downloadTicket(HttpServletRequest request, HttpSession session) {

        TicketEntity ticketEntity = (TicketEntity) session.getAttribute("ticket");

        session.invalidate();

        return new ModelAndView("pdfView", "ticketFinish", ticketEntity);
    }
}