package com.iviettech.bus.service;


import com.iviettech.bus.entity.ScheduleEntity;
import com.iviettech.bus.utils.TaiXeNotFound;

import java.util.List;

public interface ScheduleService {
    public ScheduleEntity create(ScheduleEntity scheduleEntity);
    public ScheduleEntity delete(int id) throws TaiXeNotFound;
    public List<ScheduleEntity> findAll();
    public ScheduleEntity update(ScheduleEntity scheduleEntity) throws TaiXeNotFound;
    public ScheduleEntity findById(int id);
    List<ScheduleEntity> search(String searchInput);
}
