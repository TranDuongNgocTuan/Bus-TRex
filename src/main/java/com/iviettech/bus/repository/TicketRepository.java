package com.iviettech.bus.repository;

import com.iviettech.bus.entity.TicketEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by tran on 01/09/2016.
 */
public interface TicketRepository extends CrudRepository<TicketEntity, Integer> {
    TicketEntity findByCodeTicket(String code);

    @Query(value = "DELETE FROM ticket WHERE ticket.status = 0 AND TIMESTAMPDIFF(DAY, ticket.bookedtime, :statusValue) >=1 AND :statusValue > ticket.bookedtime", nativeQuery = true)
    void deleteByStatus(@Param(value = "statusValue")Date date);


}
