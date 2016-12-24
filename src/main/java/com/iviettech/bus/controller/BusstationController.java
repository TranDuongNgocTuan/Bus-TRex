package com.iviettech.bus.controller;

import com.iviettech.bus.entity.BusstationEntity;
import com.iviettech.bus.service.BusstationService;
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
public class BusstationController {
    @Autowired
    private BusstationService busstationService;

    @RequestMapping(value="/busstation", method= RequestMethod.GET)
    public ModelAndView List(){
        ModelAndView mav=new ModelAndView("busstation");
        List<BusstationEntity> busServicesEntityList=busstationService.findAll();
        mav.addObject("busList", busServicesEntityList);
        return mav;
    }

    @RequestMapping(value = "/busstation/create",method = RequestMethod.GET)
    public String New(Model model){
        model.addAttribute("busstation", new BusstationEntity());
        return "busstationcreate";
    }

    @RequestMapping(value = "/busstation/create",method = RequestMethod.POST)
    public String createNew(BusstationEntity busServicesEntity,final RedirectAttributes redirectAttributes){
        busstationService.create(busServicesEntity);
        String message="successfully created.";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/busstation";
    }

    @RequestMapping(value="/busstation/edit/{id}", method=RequestMethod.GET)
    public ModelAndView edit(@PathVariable Integer id){
        ModelAndView mav=new ModelAndView("busstationedit");
        BusstationEntity busServicesEntity=busstationService.findById(id);
        mav.addObject("busstation", busServicesEntity);
        return mav;
    }

    @RequestMapping(value="/busstation/edit/{id}", method=RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute @Validated BusstationEntity busServicesEntity,BindingResult result,@PathVariable Integer id,final RedirectAttributes redirectAttributes) throws TaiXeNotFound {
        if (result.hasErrors())
            return new ModelAndView("busstationedit");
        ModelAndView mav=new ModelAndView("redirect:/busstation");
        String message="successfully updated.";
        busstationService.update(busServicesEntity);
        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value="/busstation/delete/{id}", method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable Integer id,final RedirectAttributes redirectAttributes) throws TaiXeNotFound {
        ModelAndView mav=new ModelAndView("redirect:/busstation");
        busstationService.delete(id);
        String message="successfully deleted.";
        redirectAttributes.addFlashAttribute("message",message);
        return mav;
    }

    @RequestMapping(value = "/busstation/search", method = GET)
    public String search(@RequestParam("searchInput")String searchInput, Model model) {
        List<BusstationEntity> resultList;
        if (searchInput.isEmpty()) {
            resultList = busstationService.findAll();
        } else {
            resultList = busstationService.search(searchInput);
        }

        model.addAttribute("busList", resultList);
        return "/busstation";
    }
}
