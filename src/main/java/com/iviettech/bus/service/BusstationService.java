package com.iviettech.bus.service;

import com.iviettech.bus.entity.BusstationEntity;
import com.iviettech.bus.utils.TaiXeNotFound;

import java.util.List;

/**
 * Created by Admin on 9/16/2016.
 */
public interface BusstationService {
    public BusstationEntity create(BusstationEntity busstationEntity);
    public BusstationEntity delete(int id) throws TaiXeNotFound;
    public List<BusstationEntity> findAll();
    public BusstationEntity update(BusstationEntity busstationEntity) throws TaiXeNotFound;
    public BusstationEntity findById(int id);
    List<BusstationEntity> search(String searchInput);
}
