package com.iviettech.bus.controller;

import com.iviettech.bus.entity.ScheduleEntity;
import com.iviettech.bus.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tran on 11/09/2016.
 */
@Controller
public class HomeController {

    @Autowired
    ScheduleRepository scheduleRepository;

    @RequestMapping(value = "/")
    public String home(Model model){
        List<ScheduleEntity> scheduleEntityListCity1 = filterQutSchedule(scheduleRepository.findByDeparture_City("Đà Nẵng"));
        List<ScheduleEntity> scheduleEntityListCity2 = filterQutSchedule(scheduleRepository.findByDeparture_City("Quảng Ngãi"));
        model.addAttribute("DaNang", scheduleEntityListCity1);
        model.addAttribute("QuangNgai", scheduleEntityListCity2);
        return "home";
    }

    public List<ScheduleEntity> filterQutSchedule(List<ScheduleEntity> scheduleEntityList){
        if (scheduleEntityList == null) return null;
        List<ScheduleEntity> scheduleEntityListFilterOut = new ArrayList<>();
        List<String> scheduleCityArrival = new ArrayList<>();
        for (ScheduleEntity scheduleEntity : scheduleEntityList){
            if (!scheduleCityArrival.contains(scheduleEntity.getArrival().getCity())){
                scheduleEntityListFilterOut.add(scheduleEntity);
                scheduleCityArrival.add(scheduleEntity.getArrival().getCity());
            }
        }
        return scheduleEntityListFilterOut;
    }
}
