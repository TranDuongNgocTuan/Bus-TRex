package com.iviettech.bus.controller;

import com.iviettech.bus.entity.ScheduleEntity;
import com.iviettech.bus.entity.TaiXeEntity;
import com.iviettech.bus.service.TaiXeService;
import com.iviettech.bus.utils.TaiXeNotFound;
import com.sun.javafx.sg.prism.NGShape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class TaiXeController {
    @Autowired
    private TaiXeService taiXeService;

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public ModelAndView newTaixe(){
        ModelAndView mav=new ModelAndView("taixe-new","taixe",new TaiXeEntity());
        return mav;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ModelAndView createNewTaiXe(@ModelAttribute @Validated TaiXeEntity taiXeEntity,BindingResult result,final RedirectAttributes redirectAttributes){
        if (result.hasErrors())
            return new ModelAndView("taixe-new");
        ModelAndView mav =new ModelAndView();
        String message="New tai xe"+taiXeEntity.getName()+"was successfully created.";
        taiXeService.create(taiXeEntity);
        mav.setViewName("/taixe");
        redirectAttributes.addFlashAttribute("message",message);
        return mav;
    }

    @RequestMapping(value="/taixe", method=RequestMethod.GET)
    public ModelAndView taiXeList(){
        ModelAndView mav=new ModelAndView("taixe");
        List<TaiXeEntity> taiXeEntityList=taiXeService.findAll();
        mav.addObject("taiXeList", taiXeEntityList);
        return mav;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editTaiXe(@PathVariable Integer id){
        ModelAndView mav=new ModelAndView("taixe-edit");
        TaiXeEntity taiXeEntity=taiXeService.findById(id);
        mav.addObject("taiXe",taiXeEntity);
        return mav;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute @Validated TaiXeEntity taiXeEntity,BindingResult result,@PathVariable Integer id,final RedirectAttributes redirectAttributes) throws TaiXeNotFound{
        if (result.hasErrors())
            return new ModelAndView("taixe-edit");
        ModelAndView mav=new ModelAndView("taixe");
        String message="Tai xe was successfully updated.";
        taiXeService.update(taiXeEntity);
        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteTaiXe(@PathVariable Integer id,final RedirectAttributes redirectAttributes) throws TaiXeNotFound{
        ModelAndView mav=new ModelAndView("taixe");
        TaiXeEntity taiXeEntity=taiXeService.delete(id);
        String message="The Tai xe"+taiXeEntity.getName()+"was successfully deleted.";
        redirectAttributes.addFlashAttribute("message",message);
        return mav;
    }

}
