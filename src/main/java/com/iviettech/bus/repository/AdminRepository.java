package com.iviettech.bus.repository;

import com.iviettech.bus.entity.AdminEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends CrudRepository<AdminEntity,Integer> {

}
