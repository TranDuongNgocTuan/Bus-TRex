package com.iviettech.bus.controller;

import com.iviettech.bus.entity.PromotionEntity;
import com.iviettech.bus.entity.PromotionTimeEntity;
import com.iviettech.bus.service.PromotionService;
import com.iviettech.bus.utils.TaiXeNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class PromotionController {
    @Autowired
    private PromotionService promotionService;

    @RequestMapping(value="/promotion", method= RequestMethod.GET)
    public ModelAndView List(){
        ModelAndView mav=new ModelAndView("promotion");
        List<PromotionEntity> promotionEntityList=promotionService.findAll();
        List<PromotionTimeEntity> promotionTimeEntityList=promotionService.findAll1();
        mav.addObject("promotionList", promotionEntityList);
        mav.addObject("promotionTime",promotionTimeEntityList);
        return mav;
    }

    @RequestMapping(value = "/promotion/create",method = RequestMethod.GET)
    public String New(Model model){
        model.addAttribute("promotion", new PromotionEntity());
        return "promotioncreate";
    }

    @RequestMapping(value = "/promotion/create",method = RequestMethod.POST)
    public String createNew(@ModelAttribute(name = "promotion")PromotionEntity promotionEntity,
                            @RequestParam(name = "datestart") Date datestart,
                            @RequestParam(name = "dateend") Date dateend){
        promotionService.create(promotionEntity);
        return "redirect:/promotion";
    }

    @RequestMapping(value="/promotion/edit/{id}", method=RequestMethod.GET)
    public ModelAndView edit(@PathVariable Integer id){
        ModelAndView mav=new ModelAndView("promotionedit");
        PromotionEntity promotionEntity=promotionService.findById(id);
        mav.addObject("promotion", promotionEntity);
        return mav;
    }

    @RequestMapping(value="/promotion/edit/{id}", method=RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute @Validated PromotionEntity promotionEntity,BindingResult result,@PathVariable Integer id,final RedirectAttributes redirectAttributes) throws TaiXeNotFound {
        if (result.hasErrors())
            return new ModelAndView("promotionedit");
        ModelAndView mav=new ModelAndView("redirect:/promotion");
        String message="successfully updated.";
        promotionService.update(promotionEntity);
        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value="/promotion/delete/{id}", method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable Integer id,final RedirectAttributes redirectAttributes) throws TaiXeNotFound{
        ModelAndView mav=new ModelAndView("redirect:/promotion");
        PromotionEntity promotionEntity=promotionService.delete(id);
        String message=promotionEntity.getName()+"successfully deleted.";
        redirectAttributes.addFlashAttribute("message",message);
        return mav;
    }

    @RequestMapping(value = "/promotion/search", method = GET)
    public String search(@RequestParam("searchInput")String searchInput, Model model) {
        List<PromotionEntity> resultList;
        if (searchInput.isEmpty()) {
            resultList = promotionService.findAll();
        } else {
            resultList = promotionService.search(searchInput);
        }

        model.addAttribute("promotionList", resultList);
        return "redirect:/promotion";
    }
}
