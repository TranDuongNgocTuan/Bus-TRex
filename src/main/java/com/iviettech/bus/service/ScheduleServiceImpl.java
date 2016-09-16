package com.iviettech.bus.service;


import com.iviettech.bus.entity.BusstationEntity;
import com.iviettech.bus.entity.InfoTicket;
import com.iviettech.bus.entity.ScheduleEntity;
import com.iviettech.bus.repository.ScheduleRepository;
import com.iviettech.bus.utils.TaiXeNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService{
    @Resource
    public ScheduleRepository scheduleRepository;

    @Override
    @Transactional
    public ScheduleEntity create(ScheduleEntity scheduleEntity){
        ScheduleEntity created=scheduleEntity;
        return scheduleRepository.save(created);
    }

    @Override
    @Transactional
    public ScheduleEntity findById(int id){
        return scheduleRepository.findOne(id);
    }

    @Override
    @Transactional(rollbackFor = TaiXeNotFound.class)
    public ScheduleEntity delete(int id) throws TaiXeNotFound{
        ScheduleEntity deleted=scheduleRepository.findOne(id);
        if (deleted==null)
            throw new TaiXeNotFound();
        scheduleRepository.delete(deleted);
        return deleted;
    }

    @Override
    @Transactional
    public List<ScheduleEntity> findAll(){
        return (List<ScheduleEntity>) scheduleRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = TaiXeNotFound.class)
    public ScheduleEntity update(ScheduleEntity scheduleEntity) throws TaiXeNotFound{
        ScheduleEntity updated=scheduleRepository.findOne(scheduleEntity.getId());
        if (updated==null)
            throw new TaiXeNotFound();

        updated.setNumberDay(scheduleEntity.getNumberDay());
        updated.setNumberTrip(scheduleEntity.getNumberTrip());
        updated.setDateStart(scheduleEntity.getDateStart());
        updated.setPriceTicket(scheduleEntity.getPriceTicket());
        updated.setDistance(scheduleEntity.getDistance());
        return updated;
    }

    @Override
    public List<ScheduleEntity> search(String searchInput) {
        searchInput = searchInput.toLowerCase();
        List<ScheduleEntity> resultList = new ArrayList<>();
        for (ScheduleEntity search: scheduleRepository.findAll()) {
            String i=Integer.toString(search.getPriceTicket());
            if (i.toLowerCase().contains(searchInput)
                    ||search.getArrival().getName().toLowerCase().contains(searchInput)
                    ||search.getDeparture().getName().contains(searchInput)){
                resultList.add(search);
            }
        }
        return resultList;
    }
}
