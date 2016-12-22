package com.iviettech.bus.repository;


import com.iviettech.bus.entity.AdminEntity;
import org.springframework.data.repository.CrudRepository;



public interface ProfileRepository extends CrudRepository<AdminEntity,Integer> {

}
