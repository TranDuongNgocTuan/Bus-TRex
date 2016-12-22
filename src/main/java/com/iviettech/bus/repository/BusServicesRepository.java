package com.iviettech.bus.repository;

import com.iviettech.bus.entity.BusServicesEntity;
import com.iviettech.bus.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

/**
 * Created by tran on 19/08/2016.
 */
public interface BusServicesRepository extends CrudRepository<BusServicesEntity, Integer> {

    @Query(value = "select busservices.* " +
            "from busservices  inner join schedule " +
            "on busservices.id = schedule.busservicesId " +
            "where schedule.departureId = :formId " +
            "and schedule.arrivalId = :toId " +
            "and datediff(:dateGo, schedule.datestart)%schedule.numberday = 0", nativeQuery = true)
    List<BusServicesEntity> findByScheduleEntityListDepartureIdAndArrivalIdAnd(@Param("formId") int from,
                                                              @Param("toId") int to,
                                                              @Param("dateGo") Date date);
}
