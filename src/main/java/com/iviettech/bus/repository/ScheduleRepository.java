package com.iviettech.bus.repository;


import com.iviettech.bus.entity.BusServicesEntity;
import com.iviettech.bus.entity.InfoTicket;
import com.iviettech.bus.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface ScheduleRepository extends CrudRepository<ScheduleEntity, Integer>{

    //Find schedule with form, to, date
//    @Query(value = "SELECT schedule," +
//            " CASE WHEN buses.date IS NULL THEN 0 ELSE  COUNT(ticket.Id) END as numberTicket" +
//            " FROM ScheduleEntity schedule "+
//            " INNER JOIN  schedule.timeTableScheduleEntityList timeTable" +
//            " LEFT JOIN timeTable.busesEntityList buses" +
//            " LEFT JOIN buses.ticketEntityList ticket" +
//            " WHERE schedule.departure = ?1 AND schedule.arrival = ?2 AND schedule.numberDay = ?3 " +
//            " GROUP BY timeTable.id")
//    List<InfoTicket> findByDepartureIdAndArrivalIdAndDate(int from, int to, int date);
}
