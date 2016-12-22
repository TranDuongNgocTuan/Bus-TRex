package com.iviettech.bus.service;

import com.iviettech.bus.entity.BusServicesEntity;
import com.iviettech.bus.repository.BusCompanyRepository;
import com.iviettech.bus.utils.TaiXeNotFound;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class BusCompanyServiceImpl implements BusCompanyService{
    @Resource
    public BusCompanyRepository busCompanyRepository;

    @Override
    @Transactional
    public BusServicesEntity create(BusServicesEntity busServicesEntity){
        BusServicesEntity created=busServicesEntity;
        return busCompanyRepository.save(created);
    }

    @Override
    @Transactional
    public BusServicesEntity findById(int id){
        return busCompanyRepository.findOne(id);
    }

    @Override
    @Transactional(rollbackFor = TaiXeNotFound.class)
    public BusServicesEntity delete(int id) throws TaiXeNotFound{
        BusServicesEntity deleted=busCompanyRepository.findOne(id);
        if (deleted==null)
            throw new TaiXeNotFound();
        busCompanyRepository.delete(deleted);
        return deleted;
    }

    @Override
    @Transactional
    public List<BusServicesEntity> findAll(){
        return (List<BusServicesEntity>) busCompanyRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = TaiXeNotFound.class)
    public BusServicesEntity update(BusServicesEntity busServicesEntity) throws TaiXeNotFound{
        BusServicesEntity updated=busCompanyRepository.findOne(busServicesEntity.getId());
        if (updated==null)
            throw new TaiXeNotFound();
        updated.setName(busServicesEntity.getName());
        updated.setAddress(busServicesEntity.getAddress());
        updated.setDescription(busServicesEntity.getDescription());
        updated.setDob(busServicesEntity.getDob());
        updated.setPhone(busServicesEntity.getPhone());
        updated.setFoundation(busServicesEntity.getFoundation());
        return updated;
    }

    @Override
    public List<BusServicesEntity> search(String searchInput) {
        searchInput = searchInput.toLowerCase();
        List<BusServicesEntity> resultList = new ArrayList<>();
        for (BusServicesEntity search: busCompanyRepository.findAll()) {
            if (search.getName().toLowerCase().contains(searchInput)
                    ||search.getPhone().toLowerCase().contains(searchInput)){
                resultList.add(search);
            }
        }
        return resultList;
    }
}
