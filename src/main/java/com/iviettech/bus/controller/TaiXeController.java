package com.iviettech.bus.controller;

import com.iviettech.bus.entity.TaiXeEntity;
import com.iviettech.bus.repository.TaiXeRepository;
import com.iviettech.bus.service.TaiXeService;
import com.iviettech.bus.utils.TaiXeNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
public class TaiXeController {
    @Autowired
    private TaiXeService taiXeService;

    @Autowired
    private TaiXeRepository taiXeRepository;

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String newTaixe(Model model){
        model.addAttribute("taiXe",new TaiXeEntity());
        return "taixecreate";
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String createNewTaiXe(TaiXeEntity taiXeEntity,final RedirectAttributes redirectAttributes){
        String message=" successfully created.";
        taiXeService.create(taiXeEntity);
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/taixe";
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
        ModelAndView mav=new ModelAndView("taixeedit");
        TaiXeEntity taiXeEntity=taiXeService.findById(id);
        mav.addObject("taiXe",taiXeEntity);
        return mav;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute @Validated TaiXeEntity taiXeEntity,BindingResult result,@PathVariable Integer id,final RedirectAttributes redirectAttributes) throws TaiXeNotFound{
        if (result.hasErrors())
            return new ModelAndView("taixeedit");
        ModelAndView mav=new ModelAndView("redirect:/taixe");
        String message="successfully updated.";
        taiXeService.update(taiXeEntity);
        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String deleteTaiXe(@PathVariable int id,final RedirectAttributes redirectAttributes, HttpServletResponse response) throws TaiXeNotFound{
        ModelAndView mav=new ModelAndView("redirect:/taixe");
        TaiXeEntity taiXeEntity = taiXeRepository.findOne(id);
        taiXeRepository.removeTaiXe(id);
        String message="The Tai xe"+taiXeEntity.getName()+"was successfully deleted.";
        redirectAttributes.addFlashAttribute("message",message);
        return "taixe";
    }

    @RequestMapping(value = "/search", method = GET)
    public String search(@RequestParam("searchInput")String searchInput, Model model) {
        List<TaiXeEntity> resultList;
        if (searchInput.isEmpty()) {
            resultList = taiXeService.findAll();
        } else {
            resultList = taiXeService.search(searchInput);
        }

        model.addAttribute("taiXeList", resultList);
        return "taixe";
    }
}
