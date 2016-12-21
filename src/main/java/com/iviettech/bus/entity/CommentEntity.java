package com.iviettech.bus.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by tran on 14/08/2016.
 */
@Entity
@Table(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;

    @Column(name = "fullname")
    private String fullName;

    private String gmail;

    @ManyToOne
    @JoinColumn(name = "rankId")
    private RankEntity rankEntity;

    private Date dob;

    private int rankOverall;

    private int rankBus;

    private int rankPunctuality;

    private int rankBehavior;

    public CommentEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public RankEntity getRankEntity() {
        return rankEntity;
    }

    public void setRankEntity(RankEntity rankEntity) {
        this.rankEntity = rankEntity;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
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
