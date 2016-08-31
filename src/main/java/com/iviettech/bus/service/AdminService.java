package com.iviettech.bus.service;

import com.iviettech.bus.entity.AdminEntity;
import com.iviettech.bus.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Admin on 8/29/2016.
 */
@Component
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public Boolean checkAdmin(String user, String pass){
        String username=user.trim();
        String password=pass.trim();
        Boolean test=false;
        List<AdminEntity> adminEntityList=(List<AdminEntity>) adminRepository.findAll();
        for(AdminEntity admin: adminEntityList){
            if ((admin.getUsername().equals(username))&&(admin.getPassword().equals(password))){
                test=true;
            }
        }
        return test;
    }
}
