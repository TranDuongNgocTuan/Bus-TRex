package com.iviettech.bus.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "schedule")
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "fromId")
    private BusstationEntity from;

    @ManyToOne
    @JoinColumn(name = "toId")
    private BusstationEntity to;

    private Date departureTime;

    private Date arriveTime;

    @ManyToOne
    @JoinColumn(name = "promotionId")
    private PromotionEntity promotionEntity;

    @OneToMany(mappedBy = "scheduleEntity")
    private List<BusesEntity> busesEntityList;

    public ScheduleEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BusstationEntity getFrom() {
        return from;
    }

    public void setFrom(BusstationEntity from) {
        this.from = from;
    }

    public BusstationEntity getTo() {
        return to;
    }

    public void setTo(BusstationEntity to) {
        this.to = to;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public PromotionEntity getPromotionEntity() {
        return promotionEntity;
    }

    public void setPromotionEntity(PromotionEntity promotionEntity) {
        this.promotionEntity = promotionEntity;
    }

    public List<BusesEntity> getBusesEntityList() {
        return busesEntityList;
    }

    public void setBusesEntityList(List<BusesEntity> busesEntityList) {
        this.busesEntityList = busesEntityList;
    }
}
