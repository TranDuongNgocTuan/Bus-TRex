package com.iviettech.bus.service;

import com.iviettech.bus.entity.AdminEntity;
import com.iviettech.bus.repository.ProfileRepository;
import com.iviettech.bus.utils.TaiXeNotFound;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ProfileServiceImpl implements ProfileService{
    @Resource
    public ProfileRepository profileRepository;

    @Override
    @Transactional
    public AdminEntity findById(int id){
        return profileRepository.findOne(id);
    }

    @Override
    @Transactional(rollbackFor = TaiXeNotFound.class)
    public AdminEntity update(AdminEntity adminEntity) throws TaiXeNotFound{
        AdminEntity updated=profileRepository.findOne(adminEntity.getId());
        if (updated==null)
            throw new TaiXeNotFound();
        updated.setUsername(adminEntity.getUsername());
        updated.setPassword(adminEntity.getPassword());
        return updated;
    }
}
