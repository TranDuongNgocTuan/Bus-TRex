package com.iviettech.bus.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by tran on 14/08/2016.
 */
@Entity
@Table(name = "statusbuses")
public class StatusBusesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "statusBusesEntity")
    private List<BusesEntity> busesEntityList;

    public StatusBusesEntity() {
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

    public List<BusesEntity> getBusesEntityList() {
        return busesEntityList;
    }

    public void setBusesEntityList(List<BusesEntity> busesEntityList) {
        this.busesEntityList = busesEntityList;
    }
}
