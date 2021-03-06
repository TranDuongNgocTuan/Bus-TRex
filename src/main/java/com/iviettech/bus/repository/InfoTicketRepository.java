package com.iviettech.bus.repository;

import com.iviettech.bus.config.SpringConfig;
import com.iviettech.bus.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import sun.security.krb5.internal.Ticket;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tran on 19/08/2016.
 */
@Repository
public class InfoTicketRepository{

    @Autowired
    private BusstationRepository busstationRepository;

    @Autowired
    private BusServicesRepository busServicesRepository;

    @Autowired
    private PromotionTimeRepository promotionTimeRepository;

    @Autowired
    private TimeTableScheduleRepository timeTableScheduleRepository;

    @Autowired
    BusesRepository busesRepository;



    private JdbcTemplate jdbcTemplate;

//    List<InfoTicket> infoTicketList;


    public InfoTicketRepository(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        jdbcTemplate = new JdbcTemplate((DataSource) context.getBean("dataSource"));
    }

    public  List<InfoTicket> findAllInfoTicket(int fromId, int toId, Date datePay){
        String sql = "SELECT schedule.* , timetableschedule.*" +
                ", case when bus.seats is null then 0 else bus.seats END as 'seat'" +
                ",case when avg(comment.rankBehavior)is null then 0 else avg(comment.rankBehavior) END as 'rankBehavior'" +
                ",case when avg(comment.rankBus)is null then 0 else avg(comment.rankBus) END as 'rankBus'" +
                ",case when avg(comment.rankOverall)is null then 0 else avg(comment.rankOverall) END as 'rankOverall'" +
                ",case when avg(comment.rankPunctuality)is null then 0 else avg(comment.rankPunctuality) END as 'rankPunctuality'" +
                " from schedule" +
                " inner join timetableschedule" +
                " on schedule.id = timetableschedule.scheduleId" +
                " inner join busservices" +
                " on busservices.id = schedule.busservicesId" +
                " inner join rank" +
                " on busservices.id = rank.id" +
                " left join comment" +
                " on rank.id = comment.rankId" +
                " left join bus" +
                " on timetableschedule.busId = bus.id" +
                " where schedule.departureId = " + fromId + " and schedule.arrivalId = " + toId + " and datediff('" +  datePay  + "', schedule.datestart)%schedule.numberday = 0" +
                " group by timetableschedule.id";
        List<InfoTicket> infoTicketList = jdbcTemplate.query(sql, new RowMapper<InfoTicket>() {

            @Override
            public InfoTicket mapRow(ResultSet rs, int rowNum) throws SQLException {
                InfoTicket aInfoTicket = new InfoTicket();
                ScheduleEntity scheduleEntity = new ScheduleEntity();
                TimeTableScheduleEntity timeTableScheduleEntity = new TimeTableScheduleEntity();

                scheduleEntity.setId(rs.getInt(1));
                scheduleEntity.setDistance(rs.getFloat("distance"));
                scheduleEntity.setNumberDay(rs.getInt("numberday"));
                scheduleEntity.setNumberTrip(rs.getInt("numbertrip"));
                scheduleEntity.setArrival(busstationRepository.findOne(rs.getInt("arrivalId")));
                scheduleEntity.setDeparture(busstationRepository.findOne(rs.getInt("departureId")));
                scheduleEntity.setBusServicesEntity(busServicesRepository.findOne(rs.getInt("busservicesId")));
                scheduleEntity.setPromotionTimeEntityList(promotionTimeRepository.findByScheduleEntityId(rs.getInt(1)));
                scheduleEntity.setTimeTableScheduleEntityList(timeTableScheduleRepository.findByScheduleEntityId(rs.getInt(10)));
                scheduleEntity.setPriceTicket(rs.getInt("priceticket"));
                scheduleEntity.setDateStart(rs.getDate("datestart"));
                timeTableScheduleEntity.setScheduleEntity(scheduleEntity);
                timeTableScheduleEntity.setId(rs.getInt(10));
                timeTableScheduleEntity.setArriveTime(rs.getTime("arriveTime"));
                timeTableScheduleEntity.setDepartureTime(rs.getTime("departuretime"));
                timeTableScheduleEntity.setDuration(rs.getTime("duration"));
                timeTableScheduleEntity.setBusesEntityList(busesRepository.findByTimeTableScheduleEntityId(rs.getInt(10)));

                aInfoTicket.setScheduleEntity(scheduleEntity);
                aInfoTicket.setTimeTableScheduleEntity(timeTableScheduleEntity);
                aInfoTicket.setNumberSeat(rs.getInt("seat"));
                aInfoTicket.setRankBehavior(rs.getFloat("rankBehavior"));
                aInfoTicket.setRankBus(rs.getFloat("rankBus"));
                aInfoTicket.setRankOverall(rs.getFloat("rankOverall"));
                aInfoTicket.setRankPunctuality(rs.getFloat("rankPunctuality"));

                PromotionTimeEntity promotionTimeEntity = promotionTimeRepository.findByScheduleEntityIdAndStartAndEnd(scheduleEntity.getId(), datePay);
                if (promotionTimeEntity != null)
                    aInfoTicket.setSell(promotionTimeEntity.getPromotionEntity().getSale());
                else
                    aInfoTicket.setSell(0);

                BusesEntity busesEntity = busesRepository.findByDateAndTimeTableScheduleEntityId(datePay, timeTableScheduleEntity.getId());
                if (busesEntity != null){
                    aInfoTicket.setBusesId(busesEntity.getId());
                    aInfoTicket.setNumberTicket(busesEntity.getTicketEntityList().size());
                    aInfoTicket.setSumNumberOfSeat(sumNumberOfSeat(busesEntity));
                }
                else {
                    aInfoTicket.setBusesId(0);
                    aInfoTicket.setNumberTicket(0);
                    aInfoTicket.setSumNumberOfSeat(0);
                }



                return aInfoTicket;
            }

        });

        return infoTicketList;
    }

    public int sumNumberOfSeat(BusesEntity busesEntity){
        int sumSeat = 0;
        for (TicketEntity ticket : busesEntity.getTicketEntityList()){
            sumSeat+= ticket.getNumberSeats();
        }
        return sumSeat;
    }

    public int daBan(BusesEntity busesEntity){
        int sumSeat = 0;
        for (TicketEntity ticket : busesEntity.getTicketEntityList()){
            if (ticket.getStatus() == 1)
                sumSeat+= ticket.getNumberSeats();
        }
        return sumSeat;
    }
}
