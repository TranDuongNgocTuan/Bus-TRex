package com.iviettech.bus.entity;

/**
 * Created by tran on 19/08/2016.
 */
public class InfoTicket{

    private ScheduleEntity scheduleEntity;

    private int numberTicket;

    private TimeTableScheduleEntity timeTableScheduleEntity;

    private int numberSeat;

    public InfoTicket() {
    }

    public InfoTicket(ScheduleEntity scheduleEntity, int numberTicket, TimeTableScheduleEntity timeTableScheduleEntity, int numberSeat) {
        this.scheduleEntity = scheduleEntity;
        this.numberTicket = numberTicket;
        this.timeTableScheduleEntity = timeTableScheduleEntity;
        this.numberSeat = numberSeat;
    }

    public ScheduleEntity getScheduleEntity() {
        return scheduleEntity;
    }

    public void setScheduleEntity(ScheduleEntity scheduleEntity) {
        this.scheduleEntity = scheduleEntity;
    }

    public int getNumberTicket() {
        return numberTicket;
    }

    public void setNumberTicket(int numberTicket) {
        this.numberTicket = numberTicket;
    }

    public TimeTableScheduleEntity getTimeTableScheduleEntity() {
        return timeTableScheduleEntity;
    }

    public void setTimeTableScheduleEntity(TimeTableScheduleEntity timeTableScheduleEntity) {
        this.timeTableScheduleEntity = timeTableScheduleEntity;
    }

    public int getNumberSeat() {
        return numberSeat;
    }

    public void setNumberSeat(int numberSeat) {
        this.numberSeat = numberSeat;
    }


}
