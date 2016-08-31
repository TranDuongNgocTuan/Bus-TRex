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

    private int rankOverall;

    private int rankBus;

    private int rankPunctuality;

    private int rankBehavior;

    @OneToMany(mappedBy = "rankEntity")
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

    public int getRankOverall() {
        return rankOverall;
    }

    public void setRankOverall(int rankOverall) {
        this.rankOverall = rankOverall;
    }

    public int getRankBus() {
        return rankBus;
    }

    public void setRankBus(int rankBus) {
        this.rankBus = rankBus;
    }

    public int getRankPunctuality() {
        return rankPunctuality;
    }

    public void setRankPunctuality(int rankPunctuality) {
        this.rankPunctuality = rankPunctuality;
    }

    public int getRankBehavior() {
        return rankBehavior;
    }

    public void setRankBehavior(int rankBehavior) {
        this.rankBehavior = rankBehavior;
    }
}
