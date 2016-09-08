package com.iviettech.bus.repository;

import com.iviettech.bus.entity.BusesEntity;
import com.iviettech.bus.entity.TicketEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sun.security.krb5.internal.Ticket;

import java.sql.Date;
import java.util.List;

/**
 * Created by tran on 15/08/2016.
 */
public interface BusesRepository extends CrudRepository<BusesEntity, Integer> {
    List<BusesEntity> findByTimeTableScheduleEntityId(int anInt);

    BusesEntity findByDateAndTimeTableScheduleEntityId(Date date, int id);

}
