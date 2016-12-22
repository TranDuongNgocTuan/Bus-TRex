package com.iviettech.bus.repository;

import com.iviettech.bus.entity.TaiXeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Admin on 9/5/2016.
 */
public interface TaiXeRepository extends CrudRepository<TaiXeEntity,Integer> {
    TaiXeEntity findByUsernameAndPassword(String username, String password);

    @Query(value = "delete from taixe where taixe.id = ?1", nativeQuery = true)
    void removeTaiXe(int id);
}
