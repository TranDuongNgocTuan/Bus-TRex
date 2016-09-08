package com.iviettech.bus.repository;

import com.iviettech.bus.entity.PromotionTimeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

/**
 * Created by tran on 20/08/2016.
 */
public interface PromotionTimeRepository  extends CrudRepository<PromotionTimeEntity, Integer>{
    List<PromotionTimeEntity> findByScheduleEntityId(int i);

    @Query("select poromotiontime from PromotionTimeEntity poromotiontime " +
            "where poromotiontime.scheduleEntity.id = ?1 " +
            "and ?2 between poromotiontime.start and poromotiontime.end")
    PromotionTimeEntity findByScheduleEntityIdAndStartAndEnd(int id, Date date);
}
