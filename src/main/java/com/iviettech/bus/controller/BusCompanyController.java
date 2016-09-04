package com.iviettech.bus.controller;

import com.iviettech.bus.entity.BusServicesEntity;
import com.iviettech.bus.repository.BusCompanyRepository;
import com.iviettech.bus.service.BusCompanyService;
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

/**
 * Created by Admin on 8/30/2016.
 */
@Controller
public class BusCompanyController {
    @Autowired
    BusCompanyRepository busCompanyRepository;
    @Autowired
    BusCompanyService busCompanyService;

    @RequestMapping(value = "/buscompany",method = GET)
    public String showBooks(Model model) {
        List<BusServicesEntity> busList = (List<BusServicesEntity>) busCompanyRepository.findAll();
        model.addAttribute("busList", busList);
        return "buscompany";
    }

    @RequestMapping(value = "/search", method = GET)
    public String search(@RequestParam("searchInput")String searchInput, Model model) {
        List<BusServicesEntity> resultList;
        if (searchInput.isEmpty()) {
            resultList = (List<BusServicesEntity>) busCompanyRepository.findAll();
        } else {
            resultList = busCompanyService.search(searchInput);
        }

        model.addAttribute("busList", resultList);
        return "buscompany";
    }

    @RequestMapping(value = "/newBusCompany", method = GET)
    public String showNewBook(Model model) {
        model.addAttribute("bus", new BusServicesEntity());
        model.addAttribute("msg", "Add a new bus company");
        model.addAttribute("action", "newBusCompany");
        return "actionbuscompany";
    }

    @RequestMapping(value = "/newBook", method = POST)
    public String saveBook(BusServicesEntity bus) {
        busCompanyRepository.save(bus);
        return "buscompany";
    }

    @RequestMapping(value = "/edit/{id}", method = GET)
    public String showEditBus(Model model, @PathVariable int id) {
        model.addAttribute("bus", busCompanyRepository.findOne(id));
        model.addAttribute("msg", "Update bus company information");
        model.addAttribute("type", "update");
        model.addAttribute("action", "/updateBus");
        return "actionbuscompany";
    }

    @RequestMapping(value = "/updateBus", method = POST)
    public String updateBus(@ModelAttribute BusServicesEntity bus) {
        busCompanyService.update(bus);
        return "buscompany";
    }

    @RequestMapping(value = "/delete/{id}", method = GET)
    public String deleteBus(@PathVariable int id) {
        busCompanyService.deleteById(id);
        return "buscompany";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
