package com.iviettech.bus.service;

import com.iviettech.bus.entity.TaiXeEntity;
import com.iviettech.bus.repository.TaiXeRepository;
import com.iviettech.bus.utils.TaiXeNotFound;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
public class TaiXeServiceImpl implements TaiXeService{
    @Resource
    private TaiXeRepository taiXeRepository;

    @Override
    @Transactional
    public TaiXeEntity create(TaiXeEntity taiXeEntity){
        TaiXeEntity createdTaiXe=taiXeEntity;
        return taiXeRepository.save(createdTaiXe);
    }

    @Override
    @Transactional
    public TaiXeEntity findById(int id){
        return taiXeRepository.findOne(id);
    }

    @Override
    @Transactional(rollbackFor = TaiXeNotFound.class)
    public TaiXeEntity delete(int id) throws TaiXeNotFound{
        TaiXeEntity deletedTaiXe=taiXeRepository.findOne(id);
        if (deletedTaiXe==null)
            throw new TaiXeNotFound();
        taiXeRepository.delete(deletedTaiXe);
        return deletedTaiXe;
    }

    @Override
    @Transactional
    public List<TaiXeEntity> findAll(){
        return (List<TaiXeEntity>) taiXeRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = TaiXeNotFound.class)
    public TaiXeEntity update(TaiXeEntity taiXeEntity) throws TaiXeNotFound{
        TaiXeEntity updatedTaiXe=taiXeRepository.findOne(taiXeEntity.getId());
        if (updatedTaiXe==null)
            throw new TaiXeNotFound();
        updatedTaiXe.setName(taiXeEntity.getName());
        return updatedTaiXe;
    }
}
