package com.iviettech.bus.entity;

import javax.persistence.*;
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

    private Date departureTime;

    private Date arriveTime;

    private int distance;

    @Column(name = "numbertrip")
    private int numberTrip;

    @Column(name = "numberday")
    private int numberDay;

    @OneToMany(mappedBy = "scheduleEntity", fetch = FetchType.EAGER)
    private List<BusesEntity> busesEntityList;

    @OneToMany(mappedBy = "scheduleEntity")
    private List<PromotionTimeEntity> promotionTimeEntityList;

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

    public List<BusesEntity> getBusesEntityList() {
        return busesEntityList;
    }

    public void setBusesEntityList(List<BusesEntity> busesEntityList) {
        this.busesEntityList = busesEntityList;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
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

}
