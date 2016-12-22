package com.iviettech.bus.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by tran on 14/08/2016.
 */
@Entity
@Table(name = "promotion")
public class PromotionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "busservicesId")
    private BusServicesEntity busServicesEntity;

    @OneToMany(mappedBy = "promotionEntity")
    private List<PromotionTimeEntity> promotionTimeEntityList;

    private int sale;



    public PromotionEntity() {
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

    public BusServicesEntity getBusServicesEntity() {
        return busServicesEntity;
    }

    public void setBusServicesEntity(BusServicesEntity busServicesEntity) {
        this.busServicesEntity = busServicesEntity;
    }

    public int getSale() { return sale; }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public List<PromotionTimeEntity> getPromotionTimeEntityList() {
        return promotionTimeEntityList;
    }

    public void setPromotionTimeEntityList(List<PromotionTimeEntity> promotionTimeEntityList) {
        this.promotionTimeEntityList = promotionTimeEntityList;
    }
}
