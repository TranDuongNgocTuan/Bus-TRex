package com.iviettech.bus.service;

import com.iviettech.bus.entity.PromotionEntity;
import com.iviettech.bus.entity.PromotionTimeEntity;
import com.iviettech.bus.utils.TaiXeNotFound;

import java.util.List;

/**
 * Created by Admin on 9/8/2016.
 */
public interface PromotionService {
    public PromotionEntity create(PromotionEntity promotionEntity);
    public PromotionEntity delete(int id) throws TaiXeNotFound;
    public List<PromotionEntity> findAll();
    public List<PromotionTimeEntity> findAll1();
    public PromotionEntity update(PromotionEntity promotionEntity) throws TaiXeNotFound;
    public PromotionEntity findById(int id);
    List<PromotionEntity> search(String searchInput);
}
