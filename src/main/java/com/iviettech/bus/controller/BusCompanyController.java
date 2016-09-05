package com.iviettech.bus.controller;

import com.iviettech.bus.entity.BusEntity;
import com.iviettech.bus.entity.BusServicesEntity;
import com.iviettech.bus.entity.PromotionEntity;
import com.iviettech.bus.entity.ScheduleEntity;
import com.iviettech.bus.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class BusCompanyController {
    @Autowired
    BusRepository busRepository;
    @Autowired
    PromotionRepository promotionRepository;
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    BusCompanyRepository busCompanyRepository;


    @RequestMapping(value = "/buscompany",method = GET)
    public String showBooks(Model model) {
        List<BusServicesEntity> busList = (List<BusServicesEntity>) busCompanyRepository.findAll();
        model.addAttribute("busList", busList);
        return "buscompany";
    }

    @RequestMapping(value = "/search", method = GET)
    public String search(@RequestParam("searchInput")String searchInput, Model model) {

        return "buscompany";
    }

    @RequestMapping(value = "/newBusCompany", method = GET)
    public String showNewBook(Model model) {
        model.addAttribute("bus", new BusServicesEntity());
        model.addAttribute("msg", "Add a new bus company");
        model.addAttribute("action", "newBusCompany");
        return "actionbuscompany";
    }

    @RequestMapping(value = "/newBus", method = POST)
    public String saveBook(BusServicesEntity bus) {
        busCompanyRepository.save(bus);
        return "buscompany";
    }

    @RequestMapping(value = "/editbuscompany/{id}", method = GET)
    public String showEditBus(Model model, @PathVariable int id) {

        return "actionbuscompany";
    }

    @RequestMapping(value = "/updateBus", method = POST)
    public String updateBus(@ModelAttribute BusServicesEntity bus) {

        return "buscompany";
    }

    @RequestMapping(value = "/delete", method = GET)
    public String deleteBus(@RequestParam(name = "id") int id) {


        busCompanyRepository.delete(id);
        return "buscompany";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
