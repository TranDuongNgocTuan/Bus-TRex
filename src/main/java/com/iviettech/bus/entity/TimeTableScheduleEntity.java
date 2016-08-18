package com.iviettech.bus.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

/**
 * Created by tran on 18/08/2016.
 */
@Entity
@Table(name = "timetableschedule")
public class TimeTableScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "departuretime")
    private Time departureTime;

    @Column(name = "arriveTime")
    private Time arriveTime;

    @ManyToOne
    @JoinColumn(name = "scheduleId")
    private ScheduleEntity scheduleEntity;

    @OneToMany(mappedBy = "timeTableScheduleEntity")
    private List<BusesEntity> busesEntityList;

    private Time duration; // Thoi gian di

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Time getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Time arriveTime) {
        this.arriveTime = arriveTime;
    }

    public ScheduleEntity getScheduleEntity() {
        return scheduleEntity;
    }

    public void setScheduleEntity(ScheduleEntity scheduleEntity) {
        this.scheduleEntity = scheduleEntity;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }
}
