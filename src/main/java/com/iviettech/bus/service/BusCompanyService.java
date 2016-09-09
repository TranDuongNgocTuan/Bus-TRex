package com.iviettech.bus.service;

import com.iviettech.bus.entity.BusServicesEntity;
import com.iviettech.bus.entity.TaiXeEntity;
import com.iviettech.bus.utils.TaiXeNotFound;

import java.util.List;

/**
 * Created by Admin on 9/7/2016.
 */
public interface BusCompanyService {
    public BusServicesEntity create(BusServicesEntity busServicesEntity);
    public BusServicesEntity delete(int id) throws TaiXeNotFound;
    public List<BusServicesEntity> findAll();
    public BusServicesEntity update(BusServicesEntity busServicesEntity) throws TaiXeNotFound;
    public BusServicesEntity findById(int id);
    List<BusServicesEntity> search(String searchInput);
}
