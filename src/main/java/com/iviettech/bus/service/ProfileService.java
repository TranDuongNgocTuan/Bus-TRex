package com.iviettech.bus.service;


import com.iviettech.bus.entity.AdminEntity;
import com.iviettech.bus.utils.TaiXeNotFound;

public interface ProfileService {
    public AdminEntity update(AdminEntity adminEntity) throws TaiXeNotFound;
    public AdminEntity findById(int id);
}
