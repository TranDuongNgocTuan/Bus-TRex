package com.iviettech.bus.repository;

import com.iviettech.bus.entity.PromotionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Admin on 9/5/2016.
 */
public interface PromotionRepository extends CrudRepository<PromotionEntity, Integer> {
    List<PromotionEntity> findById(int id);
}
