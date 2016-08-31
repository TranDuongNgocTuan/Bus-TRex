package com.iviettech.bus.controller;

import com.iviettech.bus.entity.TicketEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by tran on 29/08/2016.
 */
@Controller
public class TransferController {

    @RequestMapping(value = "/transfer")
    public String transfer(@ModelAttribute(value = "ticket") TicketEntity ticket,
                           Model model){

        model.addAttribute("ticket", ticket);

        return "transfer";
    }
}
