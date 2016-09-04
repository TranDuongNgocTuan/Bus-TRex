package com.iviettech.bus.service;

import com.iviettech.bus.entity.BusServicesEntity;

import java.util.List;

/**
 * Created by Admin on 9/4/2016.
 */
public interface BusCompanyService {

    List<BusServicesEntity> search(String searchInput);
    void deleteById(int id);
    void save(BusServicesEntity bus);
    BusServicesEntity findOne(int id);
    void update(BusServicesEntity bus);
}
