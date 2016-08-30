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
}
