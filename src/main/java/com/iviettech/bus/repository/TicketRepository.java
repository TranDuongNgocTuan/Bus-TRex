package com.iviettech.bus.repository;

import com.iviettech.bus.entity.TicketEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by tran on 01/09/2016.
 */
public interface TicketRepository extends CrudRepository<TicketEntity, Integer> {
}
