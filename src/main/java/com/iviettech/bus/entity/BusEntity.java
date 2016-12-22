package com.iviettech.bus.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by tran on 14/08/2016.
 */
@Entity
@Table(name = "bus")
public class BusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "liceseplate")
    private String licensePlate;

    private String convenient;

    private int seats;

    @ManyToOne
    @JoinColumn(name = "busservicesId")
    private BusServicesEntity busServicesEntity;

    @OneToMany(mappedBy = "busEntity", fetch = FetchType.EAGER)
    private List<TimeTableScheduleEntity> timeTableScheduleEntityList;

    @OneToOne(cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
    private TaiXeEntity taiXeEntity;

    public BusEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getConvenient() {
        return convenient;
    }

    public void setConvenient(String convenient) {
        this.convenient = convenient;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public BusServicesEntity getBusServicesEntity() {
        return busServicesEntity;
    }

    public void setBusServicesEntity(BusServicesEntity busServicesEntity) {
        this.busServicesEntity = busServicesEntity;
    }

    public List<TimeTableScheduleEntity> getTimeTableScheduleEntityList() {
        return timeTableScheduleEntityList;
    }

    public void setTimeTableScheduleEntityList(List<TimeTableScheduleEntity> timeTableScheduleEntityList) {
        this.timeTableScheduleEntityList = timeTableScheduleEntityList;
    }

    public TaiXeEntity getTaiXeEntity() {
        return taiXeEntity;
    }

    public void setTaiXeEntity(TaiXeEntity taiXeEntity) {
        this.taiXeEntity = taiXeEntity;
    }


}
