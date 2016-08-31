package com.iviettech.bus.controller;

import com.iviettech.bus.entity.*;
import com.iviettech.bus.repository.BusesRepository;
import com.iviettech.bus.repository.BusstationRepository;
import com.iviettech.bus.repository.InfoTicketRepository;
import com.iviettech.bus.repository.ScheduleRepository;
import com.iviettech.bus.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class FindTicketController {

    @Autowired
    BusstationRepository busstationRepository;

    @Autowired
    BusesRepository busesRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    InfoTicketRepository infoTicketRepository;

    /**
     * This is method perform show schedule user find with departure ,arrival and departuretime201
     * @param model
     * @return
     */
    @RequestMapping(value = "/findticket", method = RequestMethod.GET)
    public String showTicketList(@RequestParam(name = "departPlace"/*, required = false, defaultValue = "Hà Nội"*/) String from,
                                 @RequestParam(name = "destination"/*, required = false, defaultValue = "TP Hồ Chí Minh"*/) String to,
                                 @RequestParam(name = "departDate"/*, required = false, defaultValue = "2013/03/03"*/) String dateInput,
                                 Model model) {
        BusstationEntity busstationEntityFrom = busstationRepository.findByName(from); // Form
        BusstationEntity busstationEntityTo = busstationRepository.findByName(to);   // To


        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(dateInput);
//            System.out.println(dateFormat.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<InfoTicket> scheduleEntityList =
                infoTicketRepository.findAllInfoTicket(1, 2, new java.sql.Date(date.getTime()));
        List<ScheduleEntity> scheduleEntityListNormal =
                scheduleRepository.findByDepartureIdAndArrivalIdAndDate(1, 2, new java.sql.Date(date.getTime()));
        List<Integer> seats = filterQutSeat(scheduleEntityListNormal);

        model.addAttribute("from", busstationEntityFrom);
        model.addAttribute("to", busstationEntityTo);
        model.addAttribute("scheduleList", scheduleEntityList);
        model.addAttribute("scheduleListNormal", scheduleEntityListNormal);
        model.addAttribute("seatList", seats);
        model.addAttribute("dayStartMove",new java.sql.Date(date.getTime()));

        return "findticket";
    }

    @RequestMapping(value = "/findticket/comment", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String submitComment(@RequestBody String body) {
        String[] commentArr = body.split(",");
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setFullName(commentArr[0]);
        commentEntity.setGmail(commentArr[1]);
        commentEntity.setContent(commentArr[2]);
//        Comment comment = new Comment(commentArr[0], commentArr[1]);
        // save comment to DB
//        return
        return "";
    }


    public List<Integer> filterQutSeat(List<ScheduleEntity> scheduleEntityList){
        List<Integer> seats = new ArrayList<>();

        for (ScheduleEntity schedule : scheduleEntityList){
            for (TimeTableScheduleEntity timeTableScheduleEntity : schedule.getTimeTableScheduleEntityList()){
                if (!seats.contains(timeTableScheduleEntity.getBusEntity().getSeats())){
                    seats.add(timeTableScheduleEntity.getBusEntity().getSeats());
                }
            }
        }
        return seats;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
