package com.iviettech.bus.entitty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by tran on 14/08/2016.
 */
public class BusServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private Date foundation;

    private String address;

    private Date dob;

}
