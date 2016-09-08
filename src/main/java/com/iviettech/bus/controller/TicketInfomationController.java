package com.iviettech.bus.controller;

import com.iviettech.bus.entity.BusServicesEntity;
import com.iviettech.bus.entity.TicketEntity;
import com.iviettech.bus.service.TicketInfomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class TicketInfomationController {
    @Autowired
    private TicketInfomationService ticketInfomationService;

    @RequestMapping(value="/ticketinformation", method= RequestMethod.GET)
    public ModelAndView List(){
        ModelAndView mav=new ModelAndView("ticketinformation");
        List<TicketEntity> ticketEntityList=ticketInfomationService.findAll();
        mav.addObject("tho", ticketEntityList);
        return mav;
    }

    @RequestMapping(value = "/ticketinformation/search", method = GET)
    public String search(@RequestParam("searchInput")String searchInput, Model model) {
        List<TicketEntity> resultList;
        if (searchInput.isEmpty()) {
            resultList = ticketInfomationService.findAll();
        } else {
            resultList = ticketInfomationService.search(searchInput);
        }

        model.addAttribute("tho", resultList);
        return "ticketinformation";
    }
}
