package com.iviettech.bus.controller;

import com.iviettech.bus.entity.BusServicesEntity;
import com.iviettech.bus.service.BusCompanyService;
import com.iviettech.bus.utils.TaiXeNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
public class BusCompanyController {
    @Autowired
    private BusCompanyService busCompanyService;

    @RequestMapping(value="/buscompany", method=RequestMethod.GET)
    public ModelAndView List(){
        ModelAndView mav=new ModelAndView("buscompany");
        List<BusServicesEntity> busServicesEntityList=busCompanyService.findAll();
        mav.addObject("busList", busServicesEntityList);
        return mav;
    }

    @RequestMapping(value = "/buscompany/create",method = RequestMethod.GET)
    public String New(Model model){
        model.addAttribute("busCompany", new BusServicesEntity());
        return "createbuscompany";
    }

    @RequestMapping(value = "/buscompany/create",method = RequestMethod.POST)
    public String createNew(BusServicesEntity busServicesEntity,final RedirectAttributes redirectAttributes){
        busCompanyService.create(busServicesEntity);
        String message="successfully created.";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/buscompany";
    }

    @RequestMapping(value="/buscompany/edit/{id}", method=RequestMethod.GET)
    public ModelAndView edit(@PathVariable Integer id){
        ModelAndView mav=new ModelAndView("editbuscompany");
        BusServicesEntity busServicesEntity=busCompanyService.findById(id);
        mav.addObject("busCompany", busServicesEntity);
        return mav;
    }

    @RequestMapping(value="/buscompany/edit/{id}", method=RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute @Validated BusServicesEntity busServicesEntity,BindingResult result,@PathVariable Integer id,final RedirectAttributes redirectAttributes) throws TaiXeNotFound {
        if (result.hasErrors())
            return new ModelAndView("editbuscompany");
        ModelAndView mav=new ModelAndView("redirect:/buscompany");
        String message="successfully updated.";
        busCompanyService.update(busServicesEntity);
        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value="/buscompany/delete/{id}", method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable Integer id,final RedirectAttributes redirectAttributes) throws TaiXeNotFound {
        ModelAndView mav=new ModelAndView("redirect:/buscompany");
        BusServicesEntity busServicesEntity=busCompanyService.delete(id);
        String message=busServicesEntity.getName()+"successfully deleted.";
        redirectAttributes.addFlashAttribute("message",message);
        return mav;
    }

    @RequestMapping(value = "/buscompany/search", method = GET)
    public String search(@RequestParam("searchInput")String searchInput, Model model) {
        List<BusServicesEntity> resultList;
        if (searchInput.isEmpty()) {
            resultList = busCompanyService.findAll();
        } else {
            resultList = busCompanyService.search(searchInput);
        }

        model.addAttribute("busList", resultList);
        return "/buscompany";
    }
}
