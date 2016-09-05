package com.iviettech.bus.service;

import com.iviettech.bus.entity.TaiXeEntity;
import com.iviettech.bus.utils.TaiXeNotFound;

import java.util.List;

/**
 * Created by Admin on 9/5/2016.
 */
public interface TaiXeService {
    public TaiXeEntity create(TaiXeEntity taiXeEntity);
    public TaiXeEntity delete(int id) throws TaiXeNotFound;
    public List<TaiXeEntity> findAll();
    public TaiXeEntity update(TaiXeEntity taiXeEntity) throws TaiXeNotFound;
    public TaiXeEntity findById(int id);
}
