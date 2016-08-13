package com.iviettech.bus.entitty;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "schedule")
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Busstation busstation;

    private Date departureTime;

    private Date arriveTime;

    private Promotion promotion;

}
