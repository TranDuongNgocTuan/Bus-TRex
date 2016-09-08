package com.iviettech.bus.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by tran on 14/08/2016.
 */
@Entity
@Table(name = "rank")
public class RankEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
    private BusServicesEntity busServicesEntity;

    private float point;

    @OneToMany(mappedBy = "rankEntity", fetch = FetchType.EAGER)
    private List<CommentEntity> commentEntityList;

    public RankEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BusServicesEntity getBusServicesEntity() {
        return busServicesEntity;
    }

    public void setBusServicesEntity(BusServicesEntity busServicesEntity) {
        this.busServicesEntity = busServicesEntity;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    public List<CommentEntity> getCommentEntityList() {
        return commentEntityList;
    }

    public void setCommentEntityList(List<CommentEntity> commentEntityList) {
        this.commentEntityList = commentEntityList;
    }
}
