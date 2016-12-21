package com.iviettech.bus.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by tran on 14/08/2016.
 */
@Entity
@Table(name = "role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int level;

    @OneToMany(mappedBy = "roleEntity")
    private List<AdminEntity> adminEntityList;

    public RoleEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<AdminEntity> getAdminEntityList() {
        return adminEntityList;
    }

    public void setAdminEntityList(List<AdminEntity> adminEntityList) {
        this.adminEntityList = adminEntityList;
    }
}
