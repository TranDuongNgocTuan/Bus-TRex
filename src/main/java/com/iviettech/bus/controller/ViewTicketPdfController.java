package com.iviettech.bus.controller;

/**
 * Created by tran on 04/09/2016.
 */

import com.iviettech.bus.entity.TicketEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

/**
 * A Spring controller that allows the users to download a PDF document
 * generated by the iText library.
 *
 * @author www.codejava.net
 *
 */
@Controller
public class ViewTicketPdfController {

    /**
     * Handle request to download a PDF document
     */
    @RequestMapping(value = "/downloadPDF", method = RequestMethod.GET)
    public ModelAndView downloadT(HttpServletRequest request,
                                  HttpSession session) {

        TicketEntity ticketEntity = (TicketEntity) session.getAttribute("ticket");

        session.invalidate();

        return new ModelAndView("pdfView", "ticketFinish", ticketEntity);
    }
}