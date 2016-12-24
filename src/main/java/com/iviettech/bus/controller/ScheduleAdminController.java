package com.iviettech.bus.controller;

import com.iviettech.bus.entity.BusServicesEntity;
import com.iviettech.bus.entity.BusstationEntity;
import com.iviettech.bus.entity.ScheduleEntity;
import com.iviettech.bus.repository.BusServicesRepository;
import com.iviettech.bus.repository.BusstationRepository;
import com.iviettech.bus.repository.ScheduleRepository;
import com.iviettech.bus.service.ScheduleService;
import com.iviettech.bus.utils.TaiXeNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ScheduleAdminController {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private BusstationRepository busstationRepository;

    @Autowired
    private BusServicesRepository busServicesRepository;

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(value="/schedule", method= RequestMethod.GET)
    public ModelAndView List(){
        ModelAndView mav=new ModelAndView("schedule");
        List<ScheduleEntity> busServicesEntityList=scheduleService.findAll();
        mav.addObject("busList", busServicesEntityList);
        return mav;
    }

    @RequestMapping(value = "/schedule/create",method = RequestMethod.GET)
    public String New(Model model){
        model.addAttribute("schedule", new ScheduleEntity());
        List<BusstationEntity> busServicesEntityList= (List<BusstationEntity>) busstationRepository.findAll();
        List<BusServicesEntity> busServicesEntityList1= (List<BusServicesEntity>) busServicesRepository.findAll();
        model.addAttribute("busservice", busServicesEntityList);
        model.addAttribute("busservice123", busServicesEntityList1);
        return "schedulecreate";
    }

    @RequestMapping(value = "/schedule/create",method = RequestMethod.POST)
    public String createNew(@RequestParam(name = "busservice123") int name,
                            @RequestParam(name = "departure") int departure,
                            @RequestParam(name = "arrival") int arrival,
                            @RequestParam(name = "distance") float distance,
                            @RequestParam(name = "numberDay") Integer numberday,
                            @RequestParam(name = "numberTrip") int numbertrip,
                            @RequestParam(name = "dateStart") java.sql.Date datestart,
                            @RequestParam(name = "priceTicket") int priceticket,
                            final RedirectAttributes redirectAttributes)throws IOException {
        ScheduleEntity scheduleEntity=new ScheduleEntity();
        scheduleEntity.setBusServicesEntity(busServicesRepository.findOne(name));
        scheduleEntity.setDeparture(busstationRepository.findOne(departure));
        scheduleEntity.setArrival(busstationRepository.findOne(arrival));
        scheduleEntity.setDistance(distance);
        scheduleEntity.setNumberDay(numberday);
        scheduleEntity.setNumberTrip(numbertrip);
        scheduleEntity.setDateStart(datestart);
        scheduleEntity.setPriceTicket(priceticket);
        scheduleRepository.save(scheduleEntity);
        String message="successfully created.";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/schedule";
    }

    @RequestMapping(value="/schedule/edit/{id}", method=RequestMethod.GET)
    public ModelAndView edit(@PathVariable Integer id,Model model){
        ModelAndView mav=new ModelAndView("scheduleedit");
        ScheduleEntity scheduleEntity=scheduleService.findById(id);
        mav.addObject("schedule", scheduleEntity);
        List<BusstationEntity> busstationEntities= (List<BusstationEntity>) busstationRepository.findAll();
        model.addAttribute("busservice", busstationEntities);
        List<BusServicesEntity> servicesEntities= (List<BusServicesEntity>) busServicesRepository.findAll();
        model.addAttribute("busservice1", servicesEntities);
        return mav;
    }

    @RequestMapping(value="/schedule/edit/{id}", method=RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute @Validated ScheduleEntity busServicesEntity,BindingResult result,@PathVariable Integer id,final RedirectAttributes redirectAttributes, Model model) throws TaiXeNotFound {
        List<BusstationEntity> busstationEntities= (List<BusstationEntity>) busstationRepository.findAll();
        model.addAttribute("busservice", busstationEntities);
        List<BusServicesEntity> servicesEntities= (List<BusServicesEntity>) busServicesRepository.findAll();
        model.addAttribute("busservice1", servicesEntities);
        ModelAndView mav=new ModelAndView("scheduleedit");
        ScheduleEntity scheduleEntity=scheduleService.findById(id);
        mav.addObject("schedule", scheduleEntity);
        if (result.hasErrors())
            return mav;
        ModelAndView mav2=new ModelAndView("redirect:/schedule");
        String message="successfully updated.";
        scheduleService.update(busServicesEntity);
        redirectAttributes.addFlashAttribute("message", message);
        return mav2;
    }

    @RequestMapping(value="/schedule/delete/{id}", method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable Integer id,final RedirectAttributes redirectAttributes) throws TaiXeNotFound {
        ModelAndView mav=new ModelAndView("redirect:/schedule");
        scheduleService.delete(id);
        String message="successfully deleted.";
        redirectAttributes.addFlashAttribute("message",message);
        return mav;
    }

    @RequestMapping(value = "/schedule/search", method = GET)
    public String search(@RequestParam("searchInput")String searchInput, Model model) {
        List<ScheduleEntity> resultList;
        if (searchInput.isEmpty()) {
            resultList = scheduleService.findAll();
        } else {
            resultList = scheduleService.search(searchInput);
        }

        model.addAttribute("busList", resultList);
        return "/schedule";
    }
}
