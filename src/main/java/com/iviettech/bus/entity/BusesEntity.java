package com.iviettech.bus.entity;

import sun.security.krb5.internal.Ticket;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by tran on 14/08/2016.
 */
@Entity
@Table(name = "buses")
public class BusesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "statusbusesId")
    private StatusBusesEntity statusBusesEntity;

    @OneToMany(mappedBy = "busesEntity", fetch = FetchType.EAGER)
    private List<TicketEntity> ticketEntityList;

    @ManyToOne
    @JoinColumn(name = "busId")
    private BusEntity busEntity;

    @ManyToOne
    @JoinColumn(name = "timetablescheduleId")
    private TimeTableScheduleEntity timeTableScheduleEntity;

    private Date date;

    public BusesEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StatusBusesEntity getStatusBusesEntity() {
        return statusBusesEntity;
    }

    public void setStatusBusesEntity(StatusBusesEntity statusBusesEntity) {
        this.statusBusesEntity = statusBusesEntity;
    }

    public List<TicketEntity> getTicketEntityList() {
        return ticketEntityList;
    }

    public void setTicketEntityList(List<TicketEntity> ticketEntityList) {
        this.ticketEntityList = ticketEntityList;
    }

    public BusEntity getBusEntity() {
        return busEntity;
    }

    public void setBusEntity(BusEntity busEntity) {
        this.busEntity = busEntity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
