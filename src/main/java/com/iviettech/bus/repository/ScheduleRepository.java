package com.iviettech.bus.repository;


import com.iviettech.bus.entity.BusServicesEntity;
import com.iviettech.bus.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface ScheduleRepository extends CrudRepository<ScheduleEntity, Integer>{

    //Find schedule with form, to, date
    @Query(value = "SELECT * from schedule where schedule.departureId= ?1 and schedule.arrivalId  = ?2 and DATE(schedule.departureTime) = ?3", nativeQuery = true)
    List<ScheduleEntity> findByFromAndToAndDepartureTimeEqual(int from, int to, Date date );
}
