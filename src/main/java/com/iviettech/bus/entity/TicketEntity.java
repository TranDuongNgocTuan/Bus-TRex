package com.iviettech.bus.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by tran on 14/08/2016.
 */
@Entity
@Table(name = "ticket")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "busesID")
    private BusesEntity busesEntity;

    private int price;

    private Date dob;

    public TicketEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BusesEntity getBusesEntity() {
        return busesEntity;
    }

    public void setBusesEntity(BusesEntity busesEntity) {
        this.busesEntity = busesEntity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
