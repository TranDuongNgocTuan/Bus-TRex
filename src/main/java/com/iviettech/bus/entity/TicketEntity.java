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

    @Column(name = "bookedtime")
    private Date bookTime;

    @Column(name = "totalprice")
    private int totalprice;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "numberphone")
    private String numberphone;

    private String gmail;

    @Column(name = "status")
    private int status;

    private String seat;

    @Column(name = "numberseats")
    private int numberSeats;

    @Column(name = "codeticket")
    private String codeTicket;

    @ManyToOne
    @JoinColumn(name = "busesId")
    private BusesEntity busesEntity;

    @ManyToOne
    @JoinColumn(name = "busstationdeparture")
    private BusstationEntity busstationEntityDeparture;

    @ManyToOne
    @JoinColumn(name = "busstationarrival")
    private BusstationEntity busstationEntityArrival;

    public TicketEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBookTime() {
        return bookTime;
    }

    public void setBookTime(Date bookTime) {
        this.bookTime = bookTime;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }

    public BusesEntity getBusesEntity() {
        return busesEntity;
    }

    public void setBusesEntity(BusesEntity busesEntity) {
        this.busesEntity = busesEntity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public int getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(int numberSeats) {
        this.numberSeats = numberSeats;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public BusstationEntity getBusstationEntityDeparture() {
        return busstationEntityDeparture;
    }

    public void setBusstationEntityDeparture(BusstationEntity busstationEntityDeparture) {
        this.busstationEntityDeparture = busstationEntityDeparture;
    }

    public BusstationEntity getBusstationEntityArrival() {
        return busstationEntityArrival;
    }

    public void setBusstationEntityArrival(BusstationEntity busstationEntityArrival) {
        this.busstationEntityArrival = busstationEntityArrival;
    }

    public String getCodeTicket() {
        return codeTicket;
    }

    public void setCodeTicket(String codeTicket) {
        this.codeTicket = codeTicket;
    }
}