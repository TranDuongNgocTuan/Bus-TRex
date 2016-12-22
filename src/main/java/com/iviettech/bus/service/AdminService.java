package com.iviettech.bus.service;

import com.iviettech.bus.entity.AdminEntity;
import com.iviettech.bus.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public AdminEntity checkAdmin(String user, String pass){
        String username=user.trim();
        String password=pass.trim();
        Boolean test=false;
        List<AdminEntity> adminEntityList=(List<AdminEntity>) adminRepository.findAll();
        for(AdminEntity admin: adminEntityList){
            if ((admin.getUsername().equalsIgnoreCase(username))&&(admin.getPassword().equalsIgnoreCase(password))){
                return admin;
            }
        }
        return null;
    }
}
