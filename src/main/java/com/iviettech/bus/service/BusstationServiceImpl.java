package com.iviettech.bus.service;

import com.iviettech.bus.entity.BusstationEntity;
import com.iviettech.bus.repository.BusstationRepository;
import com.iviettech.bus.utils.TaiXeNotFound;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class BusstationServiceImpl implements BusstationService{
    @Resource
    public BusstationRepository busstationRepository;

    @Override
    @Transactional
    public BusstationEntity create(BusstationEntity busstationEntity){
        BusstationEntity created=busstationEntity;
        return busstationRepository.save(created);
    }

    @Override
    @Transactional
    public BusstationEntity findById(int id){
        return busstationRepository.findOne(id);
    }

    @Override
    @Transactional(rollbackFor = TaiXeNotFound.class)
    public BusstationEntity delete(int id) throws TaiXeNotFound{
        BusstationEntity deleted=busstationRepository.findOne(id);
        if (deleted==null)
            throw new TaiXeNotFound();
        busstationRepository.delete(deleted);
        return deleted;
    }

    @Override
    @Transactional
    public List<BusstationEntity> findAll(){
        return (List<BusstationEntity>) busstationRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = TaiXeNotFound.class)
    public BusstationEntity update(BusstationEntity busstationEntity) throws TaiXeNotFound{
        BusstationEntity updated=busstationRepository.findOne(busstationEntity.getId());
        if (updated==null)
            throw new TaiXeNotFound();
        updated.setCity(busstationEntity.getCity());
        updated.setName(busstationEntity.getName());
        updated.setAddress(busstationEntity.getAddress());
        return updated;
    }

    @Override
    public List<BusstationEntity> search(String searchInput) {
        searchInput = searchInput.toLowerCase();
        List<BusstationEntity> resultList = new ArrayList<>();
        for (BusstationEntity search: busstationRepository.findAll()) {
            if (search.getName().toLowerCase().contains(searchInput)
                    ||search.getAddress().toLowerCase().contains(searchInput)
                    ||search.getCity().toLowerCase().contains(searchInput)){
                resultList.add(search);
            }
        }
        return resultList;
    }
}
