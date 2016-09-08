package com.iviettech.bus.repository;

import com.iviettech.bus.entity.BusEntity;
import com.iviettech.bus.entity.BusServicesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BusRepository extends CrudRepository<BusEntity, Integer> {
    List<BusEntity> findById(int id);

    @Query("DELETE FROM  BusEntity bus WHERE bus.busServicesEntity = ?1")
    void removeAllBusOfBuservice(int id);
}
