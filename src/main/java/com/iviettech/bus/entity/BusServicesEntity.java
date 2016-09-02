package com.iviettech.bus.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by tran on 14/08/2016.
 */
@Entity
@Table(name = "busservices")
public class BusServicesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private Date foundation;

    private String address;

    private String phone;

    private Date dob;

    private String description;

    @OneToMany(mappedBy = "busServicesEntity")
    private List<ScheduleEntity> scheduleEntityList;

    @OneToOne(mappedBy = "busServicesEntity")
    private RankEntity rankEntity;

    @OneToMany(mappedBy = "busServicesEntity")
    private List<BusEntity> busEntityList;

    @OneToMany(mappedBy = "busServicesEntity")
    private List<PromotionEntity> promotionEntityList;

    @OneToMany(mappedBy = "busstationEntityDeparture")
    private List<TicketEntity> ticketEntityListDeparture;

    @OneToMany(mappedBy = "busstationEntityArrival")
    private List<TicketEntity> ticketEntityListArrival;

    public BusServicesEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFoundation() {
        return foundation;
    }

    public void setFoundation(Date foundation) {
        this.foundation = foundation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RankEntity getRankEntity() {
        return rankEntity;
    }

    public void setRankEntity(RankEntity rankEntity) {
        this.rankEntity = rankEntity;
    }

    public List<BusEntity> getBusEntityList() {
        return busEntityList;
    }

    public void setBusEntityList(List<BusEntity> busEntityList) {
        this.busEntityList = busEntityList;
    }

    public List<PromotionEntity> getPromotionEntityList() {
        return promotionEntityList;
    }

    public void setPromotionEntityList(List<PromotionEntity> promotionEntityList) {
        this.promotionEntityList = promotionEntityList;
    }

    public List<ScheduleEntity> getScheduleEntityList() {
        return scheduleEntityList;
    }

    public void setScheduleEntityList(List<ScheduleEntity> scheduleEntityList) {
        this.scheduleEntityList = scheduleEntityList;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<TicketEntity> getTicketEntityListDeparture() {
        return ticketEntityListDeparture;
    }

    public void setTicketEntityListDeparture(List<TicketEntity> ticketEntityListDeparture) {
        this.ticketEntityListDeparture = ticketEntityListDeparture;
    }

    public List<TicketEntity> getTicketEntityListArrival() {
        return ticketEntityListArrival;
    }

    public void setTicketEntityListArrival(List<TicketEntity> ticketEntityListArrival) {
        this.ticketEntityListArrival = ticketEntityListArrival;
    }
}
