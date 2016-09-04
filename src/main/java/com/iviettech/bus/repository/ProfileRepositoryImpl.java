package com.iviettech.bus.repository;

import com.iviettech.bus.entity.AdminEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 9/1/2016.
 */
@Repository
public class ProfileRepositoryImpl implements ProfileRepository {

    List<AdminEntity> adminList;

    public List<AdminEntity> findAll(){
        return adminList;
    }

    @Override
    public void deleteById(int id) {
        adminList.remove(new AdminEntity(id));
    }

    @Override
    public AdminEntity findOne(int id) {
        for(AdminEntity admin : adminList) {
            if (admin.getId() == id) {
                return admin;
            }
        }
        return null;
    }

    @Override
    public void update(AdminEntity admin) {
        deleteById(admin.getId());
        adminList.add(admin);
    }
}
