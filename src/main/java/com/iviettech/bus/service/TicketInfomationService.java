package com.iviettech.bus.service;

import com.iviettech.bus.entity.TicketEntity;

import java.util.List;


public interface TicketInfomationService {
    public List<TicketEntity> findAll();
    public TicketEntity findById(int id);
    List<TicketEntity> search(String searchInput);
}
