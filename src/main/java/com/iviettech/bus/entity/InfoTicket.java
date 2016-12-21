package com.iviettech.bus.entity;

/**
 * Created by tran on 19/08/2016.
 */
public class InfoTicket{

    private ScheduleEntity scheduleEntity;

    private int numberTicket;

    private TimeTableScheduleEntity timeTableScheduleEntity;

    private int numberSeat;

    private int busesId;

    private int sumNumberOfSeat;

    private float rankBehavior;

    private float rankBus;

    private float rankOverall;

    private float rankPunctuality;

    private int sell;

    public InfoTicket() {
    }

    public InfoTicket(ScheduleEntity scheduleEntity, int numberTicket, TimeTableScheduleEntity timeTableScheduleEntity, int numberSeat, int busesId, int sumNumberOfSeat, float rankBehavior, float rankBus, float rankOverall, float rankPunctuality, int sell) {
        this.scheduleEntity = scheduleEntity;
        this.numberTicket = numberTicket;
        this.timeTableScheduleEntity = timeTableScheduleEntity;
        this.numberSeat = numberSeat;
        this.busesId = busesId;
        this.sumNumberOfSeat = sumNumberOfSeat;
        this.rankBehavior = rankBehavior;
        this.rankBus = rankBus;
        this.rankOverall = rankOverall;
        this.rankPunctuality = rankPunctuality;
        this.sell = sell;
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

    public int getBusesId() {
        return busesId;
    }

    public void setBusesId(int busesId) {
        this.busesId = busesId;
    }

    public int getSumNumberOfSeat() {
        return sumNumberOfSeat;
    }

    public void setSumNumberOfSeat(int sumNumberOfSeat) {
        this.sumNumberOfSeat = sumNumberOfSeat;
    }

    public float getRankBehavior() {
        return rankBehavior;
    }

    public void setRankBehavior(float rankBehavior) {
        this.rankBehavior = rankBehavior;
    }

    public float getRankBus() {
        return rankBus;
    }

    public void setRankBus(float rankBus) {
        this.rankBus = rankBus;
    }

    public float getRankOverall() {
        return rankOverall;
    }

    public void setRankOverall(float rankOverall) {
        this.rankOverall = rankOverall;
    }

    public float getRankPunctuality() {
        return rankPunctuality;
    }

    public void setRankPunctuality(float rankPunctuality) {
        this.rankPunctuality = rankPunctuality;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }
}
