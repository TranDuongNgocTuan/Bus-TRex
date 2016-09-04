package com.iviettech.bus.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.iviettech.bus.entity.*;
import com.iviettech.bus.repository.*;
import com.iviettech.bus.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    BusServicesRepository busServicesRepository;

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

        BusstationEntity busstationEntityFrom = busstationRepository.findByCity(from); // Form
        BusstationEntity busstationEntityTo = busstationRepository.findByCity(to);   // To
        if (busstationEntityFrom == null || busstationEntityTo == null)
            return "error404";

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(dateInput);
//            System.out.println(dateFormat.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<InfoTicket> scheduleEntityList =
                infoTicketRepository.findAllInfoTicket(busstationEntityFrom.getId(), busstationEntityTo.getId(), new java.sql.Date(date.getTime()));
        List<ScheduleEntity> scheduleEntityListNormal =
                scheduleRepository.findByDepartureIdAndArrivalIdAndDate(busstationEntityFrom.getId(), busstationEntityTo.getId(), new java.sql.Date(date.getTime()));
        List<BusServicesEntity> busServicesEntityList =
                busServicesRepository.findByScheduleEntityListDepartureIdAndArrivalIdAnd(busstationEntityFrom.getId(), busstationEntityTo.getId(), new java.sql.Date(date.getTime()));
        List<Integer> seats = filterQutSeat(scheduleEntityListNormal);

        if(scheduleEntityList == null || scheduleEntityListNormal == null)
            return "error404";

        model.addAttribute("ticket", new TicketEntity());
        model.addAttribute("from", busstationEntityFrom);
        model.addAttribute("to", busstationEntityTo);
        model.addAttribute("scheduleList", scheduleEntityList);
        model.addAttribute("scheduleListNormal", scheduleEntityListNormal);
        model.addAttribute("buseServiceList", busServicesEntityList);
        model.addAttribute("seatList", seats);
        model.addAttribute("dayStartMove",new java.sql.Date(date.getTime()));



        return "findticket";
    }

    @RequestMapping(value = "/findticket/comment", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public @ResponseBody String submitComment(HttpServletRequest request) {

//        String[] commentArr = body.split("&");
//        CommentEntity commentEntity = new CommentEntity();
        String Name = request.getParameter("fullName");
        String gmail = request.getParameter("gmail");
        String comment = request.getParameter("comment");
        int busServiceId = Integer.parseInt(request.getParameter("busServiceId"));
        int rankOverall = Integer.parseInt(request.getParameter("rankOverall"));
        int rankBus = Integer.parseInt(request.getParameter("rankBus"));
        int rankPunctuality = Integer.parseInt(request.getParameter("rankPunctuality"));
        int rankBehavior = Integer.parseInt(request.getParameter("rankBehavior"));

        Date date = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setFullName(Name);
        commentEntity.setGmail(gmail);
        commentEntity.setDob(date);
        commentEntity.setContent(comment);
        commentEntity.setRankBus(rankBus);
        commentEntity.setRankBehavior(rankBehavior);
        commentEntity.setRankOverall(rankOverall);
        commentEntity.setRankPunctuality(rankPunctuality);
        commentEntity.setRankEntity(busServicesRepository.findOne(busServiceId).getRankEntity());

        commentRepository.save(commentEntity);

        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> hash = new HashMap<>();
        hash.put("fullName", Name);
        hash.put("gmail", gmail);
        hash.put("content", comment);
        hash.put("rankOverall", String.valueOf(rankOverall));
        hash.put("rankBus", String.valueOf(rankBus));
        hash.put("rankPunctuality", String.valueOf(rankPunctuality));
        hash.put("rankBehavior", String.valueOf(rankBehavior));
        hash.put("busServiceId", String.valueOf(busServiceId));
        hash.put("dob", String.valueOf(date));

        String ajaxResponse = "";
        try {
            ajaxResponse = mapper.writeValueAsString(hash);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ajaxResponse;
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
