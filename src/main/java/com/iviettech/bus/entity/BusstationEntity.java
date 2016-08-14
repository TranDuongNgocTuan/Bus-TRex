package com.iviettech.bus.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by tran on 14/08/2016.
 */
@Entity
@Table(name = "busstation")
public class BusstationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String city;

    private String address;

    @OneToMany(mappedBy = "to")
    private List<ScheduleEntity> scheduleToEntityList;

    @OneToMany(mappedBy = "from")
    private List<ScheduleEntity> scheduleFromEntityList;

    public BusstationEntity() {
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ScheduleEntity> getScheduleToEntityList() {
        return scheduleToEntityList;
    }

    public void setScheduleToEntityList(List<ScheduleEntity> scheduleToEntityList) {
        this.scheduleToEntityList = scheduleToEntityList;
    }

    public List<ScheduleEntity> getScheduleFromEntityList() {
        return scheduleFromEntityList;
    }

    public void setScheduleFromEntityList(List<ScheduleEntity> scheduleFromEntityList) {
        this.scheduleFromEntityList = scheduleFromEntityList;
    }
}
