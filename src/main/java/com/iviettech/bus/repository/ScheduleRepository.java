package com.iviettech.bus.repository;


import com.iviettech.bus.entity.BusServicesEntity;
import com.iviettech.bus.entity.InfoTicket;
import com.iviettech.bus.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface ScheduleRepository extends CrudRepository<ScheduleEntity, Integer>{

    //Find schedule with form, to, date
    @Query(value = "select schedule.* " +
            "from schedule  inner join busservices " +
            "on busservices.id = schedule.busservicesId " +
            "where schedule.departureId = :formId " +
            "and schedule.arrivalId = :toId " +
            "and datediff(:dateGo, busservices.dob)%schedule.numberday = 0", nativeQuery = true)
    List<ScheduleEntity> findByDepartureIdAndArrivalIdAndDate(@Param("formId") int from,
                                                              @Param("toId") int to,
                                                              @Param("dateGo") Date date);

    List<ScheduleEntity> findById(int id);
}
