package com.iviettech.bus.service;

import com.iviettech.bus.entity.TicketEntity;
import com.iviettech.bus.repository.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class TicketInfomationServiceImpl implements TicketInfomationService{
    @Resource
    public TicketRepository ticketRepository;

    @Override
    @Transactional
    public TicketEntity findById(int id){
        return ticketRepository.findOne(id);
    }

    @Override
    @Transactional
    public List<TicketEntity> findAll(){
        return (List<TicketEntity>) ticketRepository.findAll();
    }

    @Override
    public List<TicketEntity> search(String searchInput) {
        searchInput = searchInput.toLowerCase();
        List<TicketEntity> resultList = new ArrayList<>();
        for (TicketEntity search: ticketRepository.findAll()) {
            if (search.getFullName().toLowerCase().contains(searchInput)
                    ||search.getNumberphone().toLowerCase().contains(searchInput)){
                resultList.add(search);
            }

        }
        return resultList;
    }
}
