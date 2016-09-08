package com.iviettech.bus.service;

import com.iviettech.bus.entity.PromotionEntity;
import com.iviettech.bus.repository.PromotionRepository;
import com.iviettech.bus.utils.TaiXeNotFound;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService{
    @Resource
    public PromotionRepository promotionRepository;

    @Override
    @Transactional
    public PromotionEntity create(PromotionEntity promotionEntity){
        PromotionEntity created=promotionEntity;
        return promotionRepository.save(created);
    }

    @Override
    @Transactional
    public PromotionEntity findById(int id){
        return promotionRepository.findOne(id);
    }

    @Override
    @Transactional(rollbackFor = TaiXeNotFound.class)
    public PromotionEntity delete(int id) throws TaiXeNotFound{
        PromotionEntity deleted=promotionRepository.findOne(id);
        if (deleted==null)
            throw new TaiXeNotFound();
        promotionRepository.delete(deleted);
        return deleted;
    }

    @Override
    @Transactional
    public List<PromotionEntity> findAll(){
        return (List<PromotionEntity>) promotionRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = TaiXeNotFound.class)
    public PromotionEntity update(PromotionEntity promotionEntity) throws TaiXeNotFound{
        PromotionEntity updated=promotionRepository.findOne(promotionEntity.getId());
        if (updated==null)
            throw new TaiXeNotFound();
        updated.setName(promotionEntity.getName());
        updated.setSale(promotionEntity.getSale());
        return updated;
    }

    @Override
    public List<PromotionEntity> search(String searchInput) {
        searchInput = searchInput.toLowerCase();
        List<PromotionEntity> resultList = new ArrayList<>();

        for (PromotionEntity search: promotionRepository.findAll()) {
            String i=Integer.toString(search.getSale());
            if (i.toLowerCase().contains(searchInput)){
                resultList.add(search);
            }
        }
        return resultList;
    }
}
