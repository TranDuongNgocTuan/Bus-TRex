package com.iviettech.bus.repository;

import com.iviettech.bus.entity.BusesEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by tran on 15/08/2016.
 */
public interface BusesRepository extends CrudRepository<BusesEntity, Integer> {
    List<BusesEntity> findByScheduleEntityId(int id);
}
