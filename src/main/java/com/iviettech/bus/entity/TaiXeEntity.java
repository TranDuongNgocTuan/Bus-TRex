package com.iviettech.bus.entity;

import javax.persistence.*;


@Entity
@Table(name = "taixe")
public class TaiXeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToOne(cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
    private BusEntity busEntity;

    private String username;

    private String password;

    public TaiXeEntity() {
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

    public BusEntity getBusEntity() {
        return busEntity;
    }

    public void setBusEntity(BusEntity busEntity) {
        this.busEntity = busEntity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
