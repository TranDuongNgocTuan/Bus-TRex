package com.iviettech.bus.repository;

import com.iviettech.bus.entity.BusEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BusRepository extends CrudRepository<BusEntity, Integer> {
    List<BusEntity> findById(int id);
}
