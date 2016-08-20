package com.iviettech.bus.repository;

import com.iviettech.bus.entity.PromotionTimeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by tran on 20/08/2016.
 */
public interface PromotionTimeRepository  extends CrudRepository<PromotionTimeEntity, Integer>{
    List<PromotionTimeEntity> findByScheduleEntityId(int i);
}
