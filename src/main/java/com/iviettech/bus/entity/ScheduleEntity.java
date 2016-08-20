package com.iviettech.bus.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "schedule")
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "departureId")
    private BusstationEntity departure;

    @ManyToOne
    @JoinColumn(name = "arrivalId")
    private BusstationEntity arrival;

    private float distance;

    @Column(name = "numbertrip")
    private int numberTrip;

    @Column(name = "numberday")
    private int numberDay;

    @ManyToOne
    @JoinColumn(name = "busservicesId")
    private BusServicesEntity busServicesEntity;

    @OneToMany(mappedBy = "scheduleEntity")
    private List<PromotionTimeEntity> promotionTimeEntityList;

    @OneToMany(mappedBy = "scheduleEntity", fetch = FetchType.EAGER)
    private List<TimeTableScheduleEntity> timeTableScheduleEntityList;


    public ScheduleEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BusstationEntity getDeparture() {
        return departure;
    }

    public void setDeparture(BusstationEntity departure) {
        this.departure = departure;
    }

    public BusstationEntity getArrival() {
        return arrival;
    }

    public void setArrival(BusstationEntity arrival) {
        this.arrival = arrival;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getNumberTrip() {
        return numberTrip;
    }

    public void setNumberTrip(int numberTrip) {
        this.numberTrip = numberTrip;
    }

    public int getNumberDay() {
        return numberDay;
    }

    public void setNumberDay(int numberDay) {
        this.numberDay = numberDay;
    }

    public List<PromotionTimeEntity> getPromotionTimeEntityList() {
        return promotionTimeEntityList;
    }

    public void setPromotionTimeEntityList(List<PromotionTimeEntity> promotionTimeEntityList) {
        this.promotionTimeEntityList = promotionTimeEntityList;
    }

    public List<TimeTableScheduleEntity> getTimeTableScheduleEntityList() {
        return timeTableScheduleEntityList;
    }

    public void setTimeTableScheduleEntityList(List<TimeTableScheduleEntity> timeTableScheduleEntityList) {
        this.timeTableScheduleEntityList = timeTableScheduleEntityList;
    }

    public BusServicesEntity getBusServicesEntity() {
        return busServicesEntity;
    }

    public void setBusServicesEntity(BusServicesEntity busServicesEntity) {
        this.busServicesEntity = busServicesEntity;
    }
}
