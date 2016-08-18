package com.iviettech.bus.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by tran on 18/08/2016.
 */
@Entity
@Table(name = "promotiontime")
public class PromotionTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date start;

    private Date end;

    @ManyToOne
    @JoinColumn(name = "scheduleId")
    private ScheduleEntity scheduleEntity;

    @ManyToOne
    @JoinColumn(name = "promotionID")
    private PromotionEntity promotionEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public ScheduleEntity getScheduleEntity() {
        return scheduleEntity;
    }

    public void setScheduleEntity(ScheduleEntity scheduleEntity) {
        this.scheduleEntity = scheduleEntity;
    }

    public PromotionEntity getPromotionEntity() {
        return promotionEntity;
    }

    public void setPromotionEntity(PromotionEntity promotionEntity) {
        this.promotionEntity = promotionEntity;
    }
}
