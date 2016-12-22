package com.iviettech.bus.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.iviettech.bus.entity.TicketEntity;
import com.iviettech.bus.service.TicketInfomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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

    @RequestMapping("/pdfExport")
    public ModelAndView pdfExport(HttpServletResponse response) {

        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "attachment; filename=exportMy.pdf");
        List<TicketEntity> ticketEntityList=ticketInfomationService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pdfView");
        mv.addObject("tho", ticketEntityList);
        return mv;
    }

    @RequestMapping(value = "/excelExport", method = {RequestMethod.POST})
    public ModelAndView excelExport(HttpServletResponse response) {

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=myExcelExport.xls");
        List<TicketEntity> ticketEntityList=ticketInfomationService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("excelView");
        mv.addObject("tho",ticketEntityList);
        return mv;
    }

    @RequestMapping(value = "/downloadPDF", method = RequestMethod.GET)
    public ModelAndView dowloadPdf(Document doc){
        List<TicketEntity> ticketEntityList=ticketInfomationService.findAll();
        doc.setPageSize(PageSize.A3.rotate());
        return new ModelAndView("pdfViewAdmin","tho",ticketEntityList);
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
