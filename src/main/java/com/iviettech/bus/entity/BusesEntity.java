package com.iviettech.bus.entity;

import sun.security.krb5.internal.Ticket;

import javax.persistence.*;
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
    @JoinColumn(name = "scheduleId")
    private ScheduleEntity scheduleEntity;

    @ManyToOne
    @JoinColumn(name = "statusbusesId")
    private StatusBusesEntity statusBusesEntity;

    @OneToMany(mappedBy = "busesEntity")
    private List<TicketEntity> ticketEntityList;

    @OneToOne(cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
    private BusEntity busEntity;

    public BusesEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ScheduleEntity getScheduleEntity() {
        return scheduleEntity;
    }

    public void setScheduleEntity(ScheduleEntity scheduleEntity) {
        this.scheduleEntity = scheduleEntity;
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
}
