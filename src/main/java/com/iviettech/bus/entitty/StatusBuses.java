package com.iviettech.bus.entitty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by tran on 14/08/2016.
 */
public class StatusBuses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private StatusType statusType;
}
