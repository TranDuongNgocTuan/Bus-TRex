package com.iviettech.bus.repository;

import com.iviettech.bus.entity.BusServicesEntity;

import com.iviettech.bus.service.BusCompanyService;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 9/4/2016.
 */
@Repository
public class BusCompanyRepositoryImpl implements BusCompanyService{
    List<BusServicesEntity> busCompanyList;




    @Override
    public List<BusServicesEntity> search(String searchInput) {
        searchInput = searchInput.toLowerCase();
        List<BusServicesEntity> resultList = new ArrayList<>();
        for (BusServicesEntity bus: busCompanyList) {
            if (bus.getName().toLowerCase().contains(searchInput)){
                resultList.add(bus);
            }
        }
        return resultList;
    }

    @Override
    public void deleteById(int id) {
        busCompanyList.remove(new BusServicesEntity(id));
    }

    @Override
    public void save(BusServicesEntity bus) {
        bus.setId(busCompanyList.size() + 1);
        busCompanyList.add(bus);
    }

    @Override
    public BusServicesEntity findOne(int id) {
        for(BusServicesEntity bus : busCompanyList) {
            if (bus.getId() == id) {
                return bus;
            }
        }
        return null;
    }

    @Override
    public void update(BusServicesEntity bus) {
        deleteById(bus.getId());
        busCompanyList.add(bus);
    }
}
