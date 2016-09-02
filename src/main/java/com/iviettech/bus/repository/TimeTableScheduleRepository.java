package com.iviettech.bus.repository;

import com.iviettech.bus.entity.BusesEntity;
import com.iviettech.bus.entity.PromotionTimeEntity;
import com.iviettech.bus.entity.TimeTableScheduleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

/**
 * Created by tran on 20/08/2016.
 */
public interface TimeTableScheduleRepository extends CrudRepository<TimeTableScheduleEntity, Integer> {
    List<TimeTableScheduleEntity> findByScheduleEntityId(int i);
}
