package com.iviettech.bus.repository;

import com.iviettech.bus.entity.AdminEntity;

import java.util.List;

/**
 * Created by Admin on 9/1/2016.
 */

public interface ProfileRepository {
    List<AdminEntity> findAll();
    void deleteById(int id);
    AdminEntity findOne(int id);
    void update(AdminEntity adminEntity);
}
